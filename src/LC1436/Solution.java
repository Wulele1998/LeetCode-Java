package LC1436;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public String destCity(List<List<String>> paths) {
        // N: the size of `paths`
        // time: O(N)
        // space: O(N)
        Set<String> starts = new HashSet<>();
        String dest = "";

        for (List<String> path : paths) {
            starts.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!starts.contains(path.get(1))) {
                dest = path.get(1);
            }
        }

        return dest;
    }
}
