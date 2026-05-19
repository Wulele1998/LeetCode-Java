package LC210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
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
                order[completed++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int course : preMap.get(cur)) {
                preCount[course]--;
                if (preCount[course] == 0) {
                    queue.offer(course);
                    order[completed++] = course;
                }
            }
        }

        return completed == numCourses ? order : new int[] {};
    }
}
