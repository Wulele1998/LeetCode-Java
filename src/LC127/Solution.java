package LC127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String word : wordList) {
                    if (!visited.contains(word) && isConnect(cur, word)) {
                        if (word.equals(endWord))
                            return count;
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }

    private boolean isConnect(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }

        return true;
    }
}
