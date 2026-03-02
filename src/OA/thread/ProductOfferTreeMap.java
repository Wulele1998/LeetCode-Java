package OA.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ProductOfferTreeMap implements ProductOffer {
    ConcurrentHashMap<String, ConcurrentSkipListMap<Double, CopyOnWriteArraySet<String>>> productIdToOfferList;
    ConcurrentHashMap<String, String> offerIdToProductId;
    ConcurrentHashMap<String, Double> offerIdToPrice;

    public ProductOfferTreeMap() {
        productIdToOfferList = new ConcurrentHashMap<>();
        offerIdToProductId = new ConcurrentHashMap<>();
        offerIdToPrice = new ConcurrentHashMap<>();
    }

    @Override
    public void add(String productId, String offerId, double price) {
        // avoid using containsKey() method in concurrent env, since it is not an atomic action
        // violate the check-then-act rule
        // use computeIfAbsent / computeIfPresent these atomic methods

        productIdToOfferList.computeIfAbsent(productId, key -> new ConcurrentSkipListMap<>());

        ConcurrentSkipListMap<Double, CopyOnWriteArraySet<String>> map = productIdToOfferList.get(productId);
        map.computeIfAbsent(price, key -> new CopyOnWriteArraySet<>()).add(offerId);

        offerIdToProductId.put(offerId, productId);
        offerIdToPrice.put(offerId, price);
    }

    @Override
    public void remove(String offerId) {
        String productId = offerIdToProductId.remove(offerId);
        Double price = offerIdToPrice.remove(offerId);

        if (productId != null && price != null) {
            ConcurrentSkipListMap<Double, CopyOnWriteArraySet<String>> priceMap = productIdToOfferList.get(productId);
            priceMap.computeIfPresent(price, (p, offerSet) -> {
                offerSet.remove(offerId);
                return offerSet.isEmpty() ? null : offerSet;
            });

            if (priceMap.isEmpty()) {
                productIdToOfferList.remove(productId);
            }
        }
    }

    @Override
    public List<String> query(String productId, double target) {
        ConcurrentSkipListMap<Double, CopyOnWriteArraySet<String>> offerList = productIdToOfferList.get(productId);
        if (offerList == null || offerList.isEmpty()) {
            return new ArrayList<>();
        }

        Double floorPrice = offerList.floorKey(target);
        Double ceilingPrice = offerList.ceilingKey(target);


        if (floorPrice == null && ceilingPrice == null) {
            return new ArrayList<>();
        }
        if (floorPrice == null) {
            return new ArrayList<>(offerList.get(ceilingPrice));
        }
        if (ceilingPrice == null) {
            return new ArrayList<>(offerList.get(floorPrice));
        }


        if (Math.abs(floorPrice - target) > Math.abs(ceilingPrice - target)) {
            return new ArrayList<>(offerList.get(floorPrice));
        }
        if (Math.abs(floorPrice - target) < Math.abs(ceilingPrice - target)) {
            return new ArrayList<>(offerList.get(floorPrice));
        }

        List<String> result = new ArrayList<>();
        result.addAll(offerList.get(ceilingPrice));
        result.addAll(offerList.get(floorPrice));

        return result;
    }

    private List<String> getSafeList(ConcurrentSkipListMap<Double, CopyOnWriteArraySet<String>> map, Double price) {
        CopyOnWriteArraySet<String> set = map.get(price);
        // If set is null, it was removed by another thread between 'key' fetch and 'get' fetch
        return (set == null) ? new ArrayList<>() : new ArrayList<>(set);
    }
}

