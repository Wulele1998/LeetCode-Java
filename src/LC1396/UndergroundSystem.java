package LC1396;

import java.util.HashMap;
import java.util.Map;

class TravelData {
    public int timeSum;
    public int travelTimes;
    public double avg;

    public TravelData() {
        this.timeSum = 0;
        this.travelTimes = 0;
        avg = 0.0;
    }

    public void addNewTravelTime(int time) {
        this.travelTimes++;
        this.timeSum += time;
        this.avg = this.timeSum / this.travelTimes;
    }
}

class CheckInData {
    String stationName;
    int time;
    
    public CheckInData(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }
}

public class UndergroundSystem {
    Map<Integer, CheckInData> travelRecord;
    Map<String, TravelData> travelMap;

    public UndergroundSystem() {
        travelRecord = new HashMap<>();
        travelMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        travelRecord.put(id, new CheckInData(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData = travelRecord.get(id);
        String travel = checkInData.stationName + "-" + stationName;
        int duration = t - checkInData.time;
        travelMap.computeIfAbsent(travel, key -> new TravelData()).addNewTravelTime(duration);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return travelMap.get(startStation + "-" + endStation).avg;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */