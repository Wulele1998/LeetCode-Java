package OA.thread;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

record ProductOfferState (
    Map<String, TreeMap<Double, Set<String>>> productIdToOfferList,
    Map<String, String> offerIdToProductId,
    Map<String, Double> offerIdToPrice
) {}

public class ProductOfferAtomicState implements ProductOffer {
    private final AtomicReference<ProductOfferState>  stateRef = new AtomicReference<>();

    @Override
    public void add(String productId, String offerId, double price) {
        while (true) {
            ProductOfferState oldState = stateRef.get();
            Map<String, Double> offerIdToPriceNew = new HashMap<>(oldState.offerIdToPrice());
            Map<String, String> offIdToProductIdNew = new HashMap<>(oldState.offerIdToProductId());
            Map<String, TreeMap<Double, Set<String>>> productIdToOfferListNew = new HashMap<>(oldState.productIdToOfferList());

            productIdToOfferListNew.computeIfAbsent(productId, k -> new TreeMap<>())
                    .computeIfAbsent(price, k -> new HashSet<>()).add(offerId);
            offerIdToPriceNew.put(offerId, price);
            offIdToProductIdNew.put(offerId, productId);

            ProductOfferState newState = new ProductOfferState(productIdToOfferListNew, offIdToProductIdNew, offerIdToPriceNew);
            if (stateRef.compareAndSet(oldState, newState)) {
                return; // CAS operation
            }
        }
    }

    @Override
    public void remove(String offerId) {

    }

    @Override
    public List<String> query(String productId, double target) {
        return List.of();
    }
}
