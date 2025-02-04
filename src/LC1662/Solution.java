package LC1662;

public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // M: the length of `word1`
        // N: the length of `word2`
        // time: O(M + N)
        // space: O(M + N)
        StringBuilder sb1 = new StringBuilder();
        for (String word : word1) {
            sb1.append(word);
        }

        StringBuilder sb2 = new StringBuilder();
        for (String word : word2) {
            sb2.append(word);
        }
        
        return sb1.toString().equals(sb2.toString());
    }    
}
