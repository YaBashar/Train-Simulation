package unsw.trains;

// Can have a maximum of 8 trains stopped at it at any given time.
// Can store an unlimited amount of cargo and passengers.

public class CentralStation extends Station {
    public CentralStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }
}
