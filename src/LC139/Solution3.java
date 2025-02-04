package LC139;

import java.util.*;

public class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // BFS
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N) => queue and visited boolean array
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int n = s.length();
        boolean[] visited = new boolean[n];

        queue.offer(0); // start index
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= n; end++) {
                    if (set.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == n) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
        }

        return false;
    }
}
