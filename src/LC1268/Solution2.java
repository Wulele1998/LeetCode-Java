package LC1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    boolean isWord;
    List<Node> children;

    Node(boolean isWord, List<Node> children) {
        this.isWord = isWord;
        this.children = children;
    }

    Node() {
        this.isWord = false;
        this.children = Arrays.asList(new Node[26]);
    }
}

class Trie {
    Node root;
    Node current;
    List<String> wordsBuffer;
    Trie(Node root) {
        this.root = root;
    }

    /**
     * insert each string into the trie
     * @param s string
     */
    void insert(String s) {
        // build the trie
        current = root; // start from the root
        for (char c : s.toCharArray()) {
            if (current.children.get(c - 'a') == null) {
                current.children.set(c - 'a', new Node());
            }
            current = current.children.get(c - 'a');
        }

        current.isWord = true; // last character mark as word
    }

    void prefixDFS(Node current, String prefix) {
        if (wordsBuffer.size() == 3) {
            return;
        }

        if (current.isWord) {
            wordsBuffer.add(prefix);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (current.children.get(c - 'a') != null) {
                prefixDFS(current.children.get(c - 'a'), prefix + c);
            }
        }
    }

    List<String> searchPrefixStrings(String prefix) {
        current = root; // start from root
        wordsBuffer = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (current.children.get(c - 'a') == null) {
                return wordsBuffer;
            }
            current = current.children.get(c - 'a'); // next level of the tree
        }
        prefixDFS(current, prefix);
        return wordsBuffer;
    }

}

public class Solution2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie(new Node());
        List<List<String>> res = new ArrayList<>();
        for (String product : products) {
            trie.insert(product);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            res.add(trie.searchPrefixStrings(sb.toString()));
        }

        return res;
    }
}
