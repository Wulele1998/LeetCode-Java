package LC1233;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3 {
    static class TrieNode {
        boolean isEndFolder;
        HashMap<String, TrieNode> children;

        TrieNode() {
            isEndFolder = false;
            children = new HashMap<>();
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        TrieNode cur;
        // build trie for each path in the folder
        for (String path : folder) {
            cur = root;
            String[] split = path.split("/");
            for (String s : split) {
                if (!s.isEmpty()) {
                    if (!cur.children.containsKey(s)) {
                        cur.children.put(s, new TrieNode());
                    }
                    cur = cur.children.get(s);
                }
            }
            cur.isEndFolder = true;
        }

        List<String> res = new ArrayList<>();
        for (String path : folder) {
            cur = root;
            boolean flag  = false;
            String[] split = path.split("/");
            for (int i = 0; i < split.length; i++) {
                if (cur.children.get(split[i]).isEndFolder && i != split.length - 1) {
                    flag = true;
                    break;
                }
                cur = cur.children.get(split[i]);
            }

            if (!flag) {
                res.add(path);
            }
        }

        return res;
    }
}
