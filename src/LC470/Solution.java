package LC470;

/**
 * LC 470. Implement Rand10() Using Rand7()
 */
public class Solution {
    private int rand7() {
        return -1;
    }

    public int rand10() {
        // rand7() => [1, 7]
        // [1, 7] => [1, 49]
        // using rejection sampling [1, 49] => [1, 40] => [0, 39] => [0, 9] => [1, 10]
        int range;
        do {
            int row = rand7(); // [1, 7] => [0, 6]
            int col = rand7();
            range = (row - 1) * 7 + col; // range is from [1, 49]
        } while (range > 40);

        // [1, 40]
        return (range - 1) % 10 + 1;
    }
}
