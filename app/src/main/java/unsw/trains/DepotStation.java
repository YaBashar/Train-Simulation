package unsw.trains;

//Can have a maximum of 8 trains stopped at it at any given time.
// A stopping point for trains, but no passengers or cargo can be loaded or unloaded here.

public class DepotStation extends Station {
    public DepotStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }
}
