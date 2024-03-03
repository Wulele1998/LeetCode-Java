package LC3049;

import java.util.Arrays;

/**
 * LC 3049. Earliest Second to Mark Indices II
 */
public class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int[] changeIndicesAdj = Arrays.stream(changeIndices).map(index -> index - 1).toArray();
        return 0;
    }
}
