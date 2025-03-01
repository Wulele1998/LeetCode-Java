package LC2375;

/**
 * LC 2375. Construct Smallest Number From DI String
 */
public class Solution2 {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        buildSequence(0, 0, pattern.toCharArray(), sb);

        return sb.reverse().toString();
    }

    private int buildSequence(int curIndex, int curCount, char[] pattern, StringBuilder sb) {
        if (curIndex != pattern.length) {
            if (pattern[curIndex] == 'I') {
                // increase condition
                buildSequence(curIndex + 1, curIndex + 1, pattern, sb);
            } else {
                curCount = buildSequence(curIndex + 1, curCount, pattern, sb);
            }
        }
        sb.append(curCount + 1);
        return curCount + 1;
    }

}
