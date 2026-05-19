package LC355;

import java.util.*;

public class Twitter {
    private final Map<Integer, List<int[]>> tweetMap;
    private final Map<Integer, Set<Integer>> followMap;
    private int timestamp;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, _ -> new ArrayList<>()).add(new int[] {timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        // {timestamp, tweetId, index, userId}
        Queue<int[]> latestTweetHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        followMap.computeIfAbsent(userId, _ -> new HashSet<>()).add(userId);
        for (int followeeId : followMap.get(userId)) {
            // for each followee, find its tweet list
            List<int[]> tweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            if (!tweets.isEmpty()) {
                int index = tweets.size() - 1;
                int[] latestTweet = tweets.get(index);
                latestTweetHeap.offer(new int[] {latestTweet[0], latestTweet[1], index, followeeId});
            }
        }
        int count = 0;
        while (!latestTweetHeap.isEmpty() && count < 10) {
            int[] latestTweet = latestTweetHeap.poll();
            res.add(latestTweet[1]);
            int nextIndex = latestTweet[2] - 1;
            int followeeId = latestTweet[3];
            if (nextIndex >= 0) {
                int[] nextTweet = tweetMap.get(followeeId).get(nextIndex);
                latestTweetHeap.offer(new int[] {nextTweet[0], nextTweet[1], nextIndex, followeeId});
            }
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, _ -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
