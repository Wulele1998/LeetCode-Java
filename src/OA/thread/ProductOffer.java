package OA.thread;

import java.util.List;

public interface ProductOffer {
    void add(String productId, String offerId, double price);
    void remove(String offerId);
    List<String> query(String productId, double target);
}
