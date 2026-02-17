package LC23;

import library.ListNode;

import java.util.PriorityQueue;

/**
 * LC 23. Merge k Sorted Lists
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
