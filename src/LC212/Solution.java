package LC212;

import java.util.*;

public class Solution {
    static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root; // start from root node
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }

            // mark the last char in the word as a "word"
            cur.isWord = true;
        }
    }

    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean[][] visited;
    private int m; // row number
    private int n; // column number
    private Set<String> set; // store the result to avoid duplication

    public List<String> findWords(char[][] board, String[] words) {
        // build the trie DS
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n]; // default be false
        set = new HashSet<>();

        // for each cell on the board, start DFS to check if it can match any path in the trie
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // start DFS
                TrieNode start = trie.root;
                dfs(board, i, j, new StringBuilder(), start);
            }
        }

        return new ArrayList<>(set);
    }

    /**
     * DFS recursion method
     * @param board board
     * @param row current row number
     * @param col current column number
     * @param sb stores current string already matched / found
     * @param node current node at Tire
     */
    private void dfs(char[][] board, int row, int col, StringBuilder sb, TrieNode node) {
        // base case: failed
        int index = board[row][col] - 'a';
        if (node.children[index] == null) {
            // the char in current cell doesn't exist in the trie
            return;
        }

        // "base case": success
        node = node.children[index]; // update the trie node
        sb.append(board[row][col]); // update the string builder
        visited[row][col] = true; // avoid board cell re-use
        if (node.isWord) {
            set.add(sb.toString());
            // Still need to keep DFS, e.g. tea => teacher
        }

        // move to next cell in 4 directions
        for (int[] d : DIRECTIONS) {
            int nextR = row + d[0];
            int nextC = col + d[1];
            // check if next cell is valid
            // 1) the index of row and column need be in the board range
            // 2) the cell must be unvisited
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                dfs(board, nextR, nextC, sb, node);
            }
        }

        // backtrack
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
