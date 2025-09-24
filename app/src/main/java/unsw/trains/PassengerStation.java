package unsw.trains;

// Can only have 2 trains
// Can store unlimited passengers
// Cannot store cargo.
// Create an list of size 2 to hold only 2 trains

public class PassengerStation extends Station {
    public PassengerStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }
}
