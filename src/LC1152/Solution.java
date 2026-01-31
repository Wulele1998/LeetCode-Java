package LC1152;

import java.util.*;

/**
 * LC 1152: Analyze User Website Visit Pattern
 */
public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // time: O(N ^ 3)
        // space: O(N ^ 3)
        List<WebSiteVisit> visits = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            visits.add(new WebSiteVisit(username[i], timestamp[i], website[i]));
        }
        // sort in ascending order based on timestamp
        visits.sort((o1, o2) -> o1.timestamp - o2.timestamp);
        HashMap<String, List<WebSiteVisit>> userToVisit = new HashMap<>();
        for (WebSiteVisit visit : visits) {
            userToVisit.computeIfAbsent(visit.username, k -> new ArrayList<>()).add(visit);
        }
        HashMap<List<String>, Integer> patternToTimes = new HashMap<>();
        for (List<WebSiteVisit> visitList : userToVisit.values()) {
            HashSet<List<String>> set = new HashSet<>();
            for (int i = 0; i < visitList.size() - 2; i++) {
                for (int j = i + 1; j < visitList.size() - 1; j++) {
                    for (int k = j + 1; k < visitList.size(); k++) {
                        List<String> pattern = Arrays.asList(
                                visitList.get(i).website,
                                visitList.get(j).website,
                                visitList.get(k).website
                        );
                        set.add(pattern);
                    }
                }
            }

            for (List<String> key : set) {
                patternToTimes.put(key, patternToTimes.getOrDefault(key, 0) + 1);
            }
        }

        int maxVisited = 0;
        List<String> mostVisited = new ArrayList<>();
        for (Map.Entry<List<String>, Integer> entry : patternToTimes.entrySet()) {
            if (
                    (entry.getValue() > maxVisited) ||
                    (entry.getValue() == maxVisited && entry.getKey().toString().compareTo(mostVisited.toString()) < 0)
            ) {
                maxVisited = entry.getValue();
                mostVisited = entry.getKey();
            }
        }

        return mostVisited;
    }
}

class WebSiteVisit {
    String username;
    int timestamp;
    String website;

    WebSiteVisit(String username, int timestamp, String website) {
        this.username = username;
        this.timestamp = timestamp;
        this.website = website;
    }
}
