package LC808;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public double soupServings(int n) {
        if (n > 5000) {
            return 1;
        }

        int m = n % 25 == 0 ? n / 25 : n / 25 + 1;
        // op 1: A - 4, B
        // op 2: A - 3, B - 1
        // op 3: A - 2, B - 2
        // op 4: A - 1, B - 3

        // Dynamic Programming, bottom-up
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        // base case
        // A == 0, B == 0, A and B used up same time
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 0.5);

        // Transition function
        // dp(a, b) = 1/4 * (dp(a - 1, b - 3) + dp(a - 2, b - 2) + dp(a - 3, b - 1) + dp(a - 4, b))
        // if dp(a, b) => a < 0 || b < 0, get dp(0, 0)
        for (int a = 1; a <= m; a++) {
            dp.put(a, new HashMap<>());
            dp.get(a).put(0, 0.0);
            for (int b = 1; b <= m; b++) {
                dp.get(0).put(b, 1.0);
                double possibility;
                possibility = (dp.get(a - 1).get(Math.max(0, b - 3)) +
                        dp.get(Math.max(0, a - 2)).get(Math.max(0, b - 2)) +
                        dp.get(Math.max(0, a - 3)).get(b - 1) +
                        dp.get(Math.max(0, a - 4)).get(b)) / 4.0;
                dp.get(a).put(b, possibility);
            }
            if (dp.get(a).get(a) > 1 - 1e-5) {
                return 1;
            }
        }

        return dp.get(m).get(m);
    }
}
