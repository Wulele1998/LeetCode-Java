package LC1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort the product names and using binary search
        // N: the length of `products`
        // M: the length of `searchWord`
        // time: O((N + M) * logN)
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char c : searchWord.toCharArray()) {
            List<String> list = new ArrayList<>();
            prefix.append(c);
            String prefixStr = prefix.toString();
            int index = binarySearchLowBound(products, prefixStr);
            for (int i = index; i < Math.min(index + 3, products.length); i++) {
                if (products[i].startsWith(prefixStr)) {
                    list.add(products[i]);
                }
            }
            res.add(list);
        }

        return res;
    }

    private int binarySearchLowBound(String[] products, String prefixStr) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].compareTo(prefixStr) >= 0) {
                // current string is larger than prefix
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
