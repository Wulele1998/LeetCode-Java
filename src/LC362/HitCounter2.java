package LC362;

import java.util.Arrays;

public class HitCounter2 {
    int[] buffer;
    int startIndex; // [297, 298, 299, 300][1, ..., 296]
    int hits;
    int startTimestamp;
    public HitCounter2() {
        this.buffer = new int[300];
        startIndex = 0;
        hits = 0;
        startTimestamp = 0;
    }
    
    public void hit(int timestamp) {
        expire(timestamp);
        buffer[(timestamp - startTimestamp + startIndex) % 300]++;
        hits++;
    }
    
    public int getHits(int timestamp) {
        expire(timestamp);
        return hits;
    }

    private void expire(int timestamp) {
        int discardTimestamp = timestamp - 300; // [startTimestamp, startTimestamp + 299, timestamp - 299, timestamp]
        if (discardTimestamp >= startTimestamp + 299) {
            Arrays.fill(buffer, 0);
            hits = 0;
            startIndex = 0;
            startTimestamp = timestamp;
            return;
        }
        
        // [startTimestamp, ..., discardTimestamp, ... , discardTimestamp + 299]
        while (discardTimestamp >= startTimestamp) {
            hits -= buffer[startIndex];
            buffer[startIndex] = 0; // clear
            startTimestamp++;
            startIndex = (startIndex + 1) % 300;
        }
    }
}
