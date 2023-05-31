import java.util.HashMap;
import java.util.Map;

class DesignUndergroundSystem {

    Map<Integer, CheckLog> checkLogs;
    Map<String, StationRecord> stationRecords;

    public DesignUndergroundSystem() {
        checkLogs = new HashMap<>();
        stationRecords = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkLogs.put(id, new CheckLog(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // if id is already travelling, update stationRecord and remove id from
        // checkLogs
        if (checkLogs.containsKey(id)) {
            CheckLog cl = checkLogs.get(id);
            String route = cl.stationName + "-" + stationName;
            stationRecords.put(route,
                    stationRecords.getOrDefault(route, new StationRecord(t - cl.time)).update(t - cl.time));
            checkLogs.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        StationRecord sr = stationRecords.get(route);
        return sr.getAverageTime();
    }

    static class CheckLog {
        String stationName;
        int time;

        CheckLog(String s, int t) {
            stationName = s;
            time = t;
        }

        public String toString() {
            return this.stationName + " " + this.time;
        }

    }

    static class StationRecord {
        int time;
        int count;

        StationRecord(int time) {
            this.time = 0;
        }

        StationRecord update(int time) {
            this.time += time;
            this.count++;
            return this;
        }

        double getAverageTime() {
            return (double) this.time / this.count;
        }

        public String toString() {
            return this.time + " " + this.count + " ->" + this.getAverageTime();
        }

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */