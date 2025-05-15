package LC1007;

public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int numA = check(tops[0], tops, bottoms);
        int numB = check(bottoms[0], tops, bottoms);

        return Math.min(numA, numB) == Integer.MAX_VALUE ? -1 : Math.min(numA, numB);

    }

    private int check(int target, int[] arrA, int[] arrB) {
        int n = arrA.length;
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < n; i++) {
           if (arrA[i] != target && arrB[i] != target) {
               return Integer.MAX_VALUE;
           } else if (arrA[i] != target) {
               countA++;
           } else if (arrB[i] != target) {
                countB++;
           }
        }

        return Math.min(countA, countB);
    }
}
