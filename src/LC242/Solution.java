package LC242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        // N: the length of `s`
        // M: the length of `t`
        // time complexity: O(max(M, N))
        // space complexity: O(1)
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }
}
