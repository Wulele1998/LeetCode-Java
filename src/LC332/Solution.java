package LC332;

import java.util.*;

public class Solution {
    // E: the number of all tickets
    // time: O(E * logE)
    private Map<String, Queue<String>> adjMap;
    private List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjMap.computeIfAbsent(ticket.get(0), _ -> new PriorityQueue<>()).add(ticket.get(1));
        }

        res = new ArrayList<>();

        findEulerianPath();

        return res;
    }

    private void findEulerianPath() {
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String topAirport = stack.peek();
            if (adjMap.containsKey(topAirport) && !adjMap.get(topAirport).isEmpty()) {
                stack.push(adjMap.get(topAirport).poll());
            } else {
                stack.pop();
                res.addFirst(topAirport);
            }
        }
    }
}
