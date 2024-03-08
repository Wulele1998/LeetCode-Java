package LC5;


/**
 * LC 5. Longest Palindromic Substring
 */
public class Solution4 {
    public String longestPalindrome(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for (char c: s.toCharArray()) {
            sPrime.append(c).append("#");
        }
        
        int n = sPrime.length();
        int[] palindromeRadis = new int[n];
        int center = 0;
        int radius = 0;
        
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            
            if (i < radius) {
                palindromeRadis[i] = Math.min(radius - i, palindromeRadis[mirror]);
            }
            
            while (i + 1 + palindromeRadis[i] < n &&
                   i - 1 - palindromeRadis[i] >= 0 &&
                   sPrime.charAt(i + 1 + palindromeRadis[i]) == sPrime.charAt(i - 1 - palindromeRadis[i])) {
                palindromeRadis[i]++;
            }
            
            if (i + palindromeRadis[i] > radius) {
                center = i;
                radius = i + palindromeRadis[i];
            }
        }
        
        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadis[i] > maxLength) {
                maxLength = palindromeRadis[i];
                centerIndex = i;
            }
        }
        
        int startIndex = (centerIndex - maxLength) / 2;
        String longestPalindrome = s.substring(startIndex, startIndex + maxLength);
        
        return longestPalindrome;
    }
}
