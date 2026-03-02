package OA.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.StampedLock;

class DoubleLinkedNode {
    String offerId;
    Double price;
    DoubleLinkedNode next;
    DoubleLinkedNode prev;
    public DoubleLinkedNode(String offerId, Double price) {
        this.offerId = offerId;
        this.price = price;
        prev = null;
        next = null;
    }
}

class DoubleLinkedList {
    Map<String, DoubleLinkedNode> map;
    DoubleLinkedNode dummyHead;
    DoubleLinkedNode dummyTail;
    StampedLock lock;
    volatile AtomicInteger size;

    public DoubleLinkedList() {
        dummyHead = new DoubleLinkedNode("dummy head", -1.0);
        dummyTail = new DoubleLinkedNode("dummy tail", -1.0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        lock = new StampedLock();
        map = new HashMap<>();
        size = new AtomicInteger(0);
    }

    // O(1)
    public void add(DoubleLinkedNode node) {
        // write operation, need to use write lock
        long stamp = lock.writeLock();
        try {
            map.put(node.offerId, node);
            DoubleLinkedNode headElement = dummyHead.next;
            dummyHead.next = node;
            node.prev = dummyHead;

            node.next = headElement;
            headElement.prev = node;

            size.getAndIncrement();
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    // O(1)
    public void remove(String offerId) {
        long stamp = lock.writeLock();
        try {
            DoubleLinkedNode offerNode = map.get(offerId);
            map.remove(offerId);
            offerNode.prev.next = offerNode.next;
            offerNode.next.prev = offerNode.prev;

            size.getAndDecrement();
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public int size() {
        return size.get();
    }

    public DoubleLinkedNode getHead() {
        return dummyHead.next;
    }
}

public class ProductOfferDoubledLinkedList implements ProductOffer {
    ConcurrentHashMap<String, DoubleLinkedList> productIdToOfferList;
    ConcurrentHashMap<String, String> offerIdToProductId;

    public ProductOfferDoubledLinkedList() {
        productIdToOfferList = new ConcurrentHashMap<>();
        offerIdToProductId = new ConcurrentHashMap<>();
    }

    // add an offer for the product
    @Override
    public void add(String productId, String offerId, double price) {
        offerIdToProductId.put(offerId, productId);

        if (!productIdToOfferList.containsKey(productId)) {
            productIdToOfferList.put(productId, new DoubleLinkedList());
        }
        productIdToOfferList.get(productId).add(new DoubleLinkedNode(offerId, price));
    }

    // remove an offer
    @Override
    public void remove(String offerId) {
        String productId = offerIdToProductId.get(offerId);
        productIdToOfferList.get(productId).remove(offerId);
    }

    // O(N)
    @Override
    public List<String> query(String productId, double target) {
        DoubleLinkedList offerList = productIdToOfferList.get(productId);
        if (offerList == null)
            return new ArrayList<>();
        long stamp = offerList.lock.tryOptimisticRead();
        int size = offerList.size();
        DoubleLinkedNode head = offerList.getHead();
        List<String> res = performScan(productId, size, head, target);

        if (!offerList.lock.validate(stamp)) {
            stamp = offerList.lock.readLock();
            try {
                size = offerList.size();
                head = offerList.getHead();
                res = performScan(productId, size, head, target);
            } finally {
                offerList.lock.unlockRead(stamp);
            }
        }

        return res;
    }


    private List<String> performScan(String productId, int size, DoubleLinkedNode head, double target) {
        DoubleLinkedNode cur = head;
        List<String> list = new ArrayList<>();

        double delta = Double.MAX_VALUE;
        for (int i = 0; i < size && cur != null && cur.price != -1.0; i++) {
            if (Math.abs(cur.price - target) < delta) {
                list.clear();
                delta = Math.abs(cur.price - target);
                list.add(cur.offerId);
            }
            cur = cur.next;
        }

        return list;
    }



    public static void main(String[] args) {
        ProductOfferDoubledLinkedList test = new ProductOfferDoubledLinkedList();
        test.add("A", "Offer1", 9.0);
        test.add("A", "Offer2", 8.0);
        test.add("A", "Offer3", 10.0);

        // test.remove("Offer1");

        System.out.println(test.query("A", 8.15));

        System.out.println(test.productIdToOfferList.get("A").size());
    }
}
