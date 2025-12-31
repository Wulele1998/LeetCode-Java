package LC3606;

import java.util.*;

/**
 * Dec 13, 2025
 * LC 3606. Coupon Code Validator
 */
public class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // time: O(N * log N)
        // space: O(log N)
        List<String> res = new ArrayList<>();
        int n = code.length;
        List<String>[] categories = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            categories[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (!isActive[i] || !isValidCode(code[i])) {
                continue;
            }
            switch (businessLine[i]) {
                case "electronics":
                    categories[0].add(code[i]);
                    break;
                case "grocery":
                    categories[1].add(code[i]);
                    break;
                case "pharmacy":
                    categories[2].add(code[i]);
                    break;
                case "restaurant":
                    categories[3].add(code[i]);
                    break;
                default:
            }
        }

        for (int i = 0; i < 4; i++) {
            Collections.sort(categories[i]);
            res.addAll(categories[i]);
        }

        return res;
    }

    private boolean isValidCode(String code) {
        if (code.isEmpty()) {
            return false;
        }

        for (char c : code.toCharArray()) {
            if (c != '_' && !Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
