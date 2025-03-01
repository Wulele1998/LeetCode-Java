package LC1352;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    // time: O(K)
    public int getProduct(int k) {
        int product = 1;
        for (int i = list.size() - 1; i >= 0 && k > 0; i--, k--) {
            product *= list.get(i);
        }

        return product;
    }
}
