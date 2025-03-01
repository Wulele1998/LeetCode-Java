package LC2375;

/**
 * LC 2375. Construct Smallest Number From DI String
 */
public class Solution3 {
    public String smallestNumber(String pattern) {
        // N: the length of pattern
        // time: O(N)
        // space: O(N)
        int n = pattern.length();
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
           res[i] = i + 1;
        }

        int prev = 0;
        int cur = 0;
        while (cur < n) {
           if (pattern.charAt(cur) == 'I') {
               prev++;
               cur++;
           } else {
               prev = cur;
               while (cur < n && pattern.charAt(cur) == 'D') {
                   // search how many continuous D are there
                   cur++;
               }
               // [prev, cur - 1] are D sequence
               // we need to swap the number from res[prev, cur]
               //  I I I D I
               // 1 2 3 4 5
               // prev = 3, cur = 4
               int l = prev, r = cur;
               while (l < r) {
                   int temp = res[l];
                   res[l++] = res[r];
                   res[r--] = temp;
               }
               prev = cur;
           }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
           sb.append(num);
        }


        return sb.toString();
    }
}
