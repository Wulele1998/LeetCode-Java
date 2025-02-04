package LC752;

import java.util.*;

/**
 * LC 752. Open the Lock
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        // BFS
        List<char[]> adj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                adj.add(new char[] {'9', '1'});
            } else if (i == 9) {
                adj.add(new char[] {'8', '0'});
            } else {
                adj.add(new char[] {(char)(i - 1 + '0'), (char)(i + 1 + '0')});
            }
        }

        int count = 0;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder(poll);
                    for (int k = 0; k < 2; k++) {
                        sb.setCharAt(j, adj.get(poll.charAt(j) - '0')[k]);
                        if (!visited.contains(sb.toString())) {
                            queue.add(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
