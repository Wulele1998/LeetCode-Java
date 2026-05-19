package LC207;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        int[] preCount = new int[numCourses];

        for (int courseId = 0; courseId < numCourses; courseId++) {
            preMap.put(courseId, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            preMap.get(pre[1]).add(pre[0]);
            preCount[pre[0]]++;
        }

        int completed = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                // current course doesn't have pre course required
                queue.offer(i);
                completed++;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int course : preMap.get(cur)) {
                preCount[course]--;
                if (preCount[course] == 0) {
                    queue.offer(course);
                    completed++;
                }
            }
        }

        return completed == numCourses;
    }
}
