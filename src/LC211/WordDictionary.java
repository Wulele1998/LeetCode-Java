package LC211;

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return searchFromIndex(cur, word, 0);
    }

    private boolean searchFromIndex(TrieNode node, String word, int index) {
        TrieNode cur = node;
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) != '.') {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[word.charAt(i) - 'a'];
                }
            } else {
                for (TrieNode child : cur.children) {
                    if (child != null && searchFromIndex(child, word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }

        return cur.isWord;
    }
}
