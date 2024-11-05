package LC1700;

/**
 * LC 1700. Number of Students Unable to Eat Lunch
 */
public class Solution2 {
    public int countStudents(int[] students, int[] sandwiches) {
        // N: the length of `students`
        // time: O(N)
        // space: O(1)
        int circleCount = 0;
        int squareCount = 0;
        
        for (int student : students) {
            if (student == 0)
                circleCount++;
            else 
                squareCount++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && circleCount == 0) {
                return squareCount;
            }
            if (sandwich == 1 && squareCount == 0) {
                return circleCount;
            }
            if (sandwich == 0) {
                circleCount--;
            } else {
                squareCount--;
            }
        }

        return 0;
    }
}
