package LC759;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution {
    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // N: the number of employees
        // K: the number of all the intervals of all employees
        // time: O(K * logN)
        // space: O(N)
        List<Interval> workTime = new ArrayList<>();

        // {start, end, employee index, interval index}
        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int n = schedule.size(); // the number of employee
        for (int i = 0; i < n; i++) {
            List<Interval> emp = schedule.get(i);
            if (!emp.isEmpty()) {
                Interval interval = emp.getFirst();
                minHeap.offer(new int[] {interval.start, interval.end, i, 0});
            }
        }

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (workTime.isEmpty() || workTime.getLast().end < cur[0]) {
                workTime.add(new Interval(cur[0], cur[1]));
            } else {
                int prevEnd = workTime.getLast().end;
                workTime.getLast().end = Math.max(prevEnd, cur[1]); // update the end time of prev interval
            }

            int empIndex = cur[2];
            int intervalIndex = cur[3];
            if (intervalIndex < schedule.get(empIndex).size() - 1) {
                Interval next = schedule.get(empIndex).get(intervalIndex + 1);
                minHeap.offer(new int[] {next.start, next.end, empIndex, intervalIndex + 1});
            }
        }

        return getFreeTime(workTime);
    }

    private List<Interval> getFreeTime(List<Interval> workTime) {
        List<Interval> freeTime = new ArrayList<>();
        if (workTime.isEmpty()) {
            return freeTime;
        }

        for (int i = 1; i < workTime.size(); i++) {
            if (workTime.get(i).start > workTime.get(i - 1).end) {
                freeTime.add(new Interval(workTime.get(i - 1).end, workTime.get(i).start));
            }
        }

        return freeTime;
    }
}
