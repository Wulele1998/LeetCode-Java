package LC1105;

/**
 * LC 1105 Filling Bookcase Shelves
 */
public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 2; i < n + 1; i++) {
            // option 1: put the book in a new one
            dp[i] = dp[i - 1] + books[i - 1][1];
            int remainWidth = shelfWidth - books[i - 1][0];
            int maxHeight = books[i - 1][1];

            int j = i - 1;
            while (j > 0 && remainWidth - books[j - 1][0] >= 0) {
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                remainWidth -= books[j - 1][0];
                dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                j--;
            }
        }

        return dp[n];
    }
}
