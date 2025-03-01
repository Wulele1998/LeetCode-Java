package LC1352;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers2 {
    List<Integer> prefixProduct;
    int size;
    public ProductOfNumbers2() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
        size = 0;
    }

    // time: O(1)
    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
            size = 0;
        } else {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
            size++;
        }
    }

    // time: O(1)
    public int getProduct(int k) {
        if (size < k) {
            return 0;
        }

        return prefixProduct.get(size) / prefixProduct.get(size - k);
    }
}
