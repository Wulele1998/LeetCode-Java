package LC2092;

import java.util.*;

/**
 * LC 2092. Find All People With Secret
 */
public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // M: the number of `meetings`
        // N: the number of people
        // time: O(M * (M + N)
        // space: O(M + N)
        // BFS
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            graph.computeIfAbsent(meeting[0], key -> new ArrayList<>()).add(new int[]{meeting[1], meeting[2]});
            graph.computeIfAbsent(meeting[0], key -> new ArrayList<>()).add(new int[]{meeting[0], meeting[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // person 0 get the secret at time 0
        queue.add(new int[]{firstPerson, 0}); // `firstPerson` get the secret at time 0
        int[] visitedTime = new int[n];
        Arrays.fill(visitedTime, Integer.MAX_VALUE);
        visitedTime[0] = 0;
        visitedTime[firstPerson] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int person = cur[0];
            int time = cur[1];

            for (int[] node : graph.getOrDefault(person, new ArrayList<>())) {
                int nodePerson = node[0];
                int meetingTime = node[1];
                if (meetingTime >= time && visitedTime[nodePerson] > meetingTime) {
                    visitedTime[nodePerson] = meetingTime;
                    queue.add(new int[]{nodePerson, meetingTime});
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visitedTime[i] != Integer.MAX_VALUE)
                res.add(i);
        }

        return res;
    }
}
