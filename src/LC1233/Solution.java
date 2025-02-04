package LC1233;

import java.util.*;

/**
 * LC 1233. Remove Sub-Folders from the Filesystem
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        List<String> res = new ArrayList<>();

        for (String s : folder) {
            String parentPath = s;
            boolean flag = false;
            while (!parentPath.isEmpty()) {
                int index = parentPath.lastIndexOf("/");

                parentPath = parentPath.substring(0, index);

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
