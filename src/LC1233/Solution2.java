package LC1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    // using sort
    public List<String> removeSubfolders(String[] folder) {
        // N: the number of strings in the `folder`
        // M: the length of longest path in the `folder`
        // time: O(N * L * log N)
        // space: O(N * L)
        Arrays.sort(folder); // quick sort needs O(N * L * log N)
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        int index = 0;
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(res.get(index) + "/")) {
                res.add(folder[i]);
                index++;
            }
        }

        return res;
    }
}
