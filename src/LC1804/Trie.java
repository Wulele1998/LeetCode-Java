package LC1804;

class TrieNode {
    int prefixCount;
    int wordCount;
    TrieNode[] children;

    public TrieNode() {
        prefixCount = 0;
        wordCount = 0;
        children = new TrieNode[26];
    }
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur.children[c - 'a'].prefixCount++;
            cur = cur.children[c - 'a'];
        }
        cur.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }

        return cur.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }

        return cur.prefixCount;
    }

    public void erase(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return;
            }
            cur.children[c - 'a'].prefixCount--;
            cur = cur.children[c - 'a'];
        }

        cur.wordCount--;
    }
}