package LC1233;

import java.util.*;

/**
 * LC 1233. Remove Sub-Folders from the Filesystem
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // N: the number of strings in the `folder`
        // M: the length of longest path in the `folder`
        // time: O(N * M ^ 2)
        // space: O(N * M)
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        List<String> res = new ArrayList<>();

        for (String s : folder) {
            String parentPath = s;
            boolean flag = false;
            while (!parentPath.isEmpty()) {
                int index = parentPath.lastIndexOf("/"); // O(M)

                parentPath = parentPath.substring(0, index); // O(M)

                if (set.contains(parentPath)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                res.add(s);
            }
        }

        return res;
    }
}
