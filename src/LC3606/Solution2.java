package LC3606;

import java.util.*;

class Coupon implements Comparable<Coupon> {
    String code;
    int businessLine;

    Coupon(String code, int businessLine) {
        this.code = code;
        this.businessLine = businessLine;
    }

    @Override
    public int compareTo(Coupon o) {
        if (this.businessLine == o.businessLine) {
            return this.code.compareTo(o.code);
        } else {
            return this.businessLine - o.businessLine;
        }
    }
}

public class Solution2 {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // time: O(N * log N)
        // space: O(log N)
        List<Coupon> validCoupons = new ArrayList<>();
        HashMap<String, Integer> businessLinePriority = new HashMap<>();
        businessLinePriority.put("electronics", 1);
        businessLinePriority.put("grocery", 2);
        businessLinePriority.put("pharmacy", 3);
        businessLinePriority.put("restaurant", 4);

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && isValidCode(code[i]) && businessLinePriority.containsKey(businessLine[i])) {
                validCoupons.add(new Coupon(code[i], businessLinePriority.get(businessLine[i])));
            }
        }

        Collections.sort(validCoupons);

        List<String> res =  new ArrayList<>();
        for (Coupon coupon : validCoupons) {
            res.add(coupon.code);
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
