package unsw.trains;

// Can have maximum of 4 trains
// Can store unlimited cargo
// Cannot store passengers

public class CargoStation  extends Station {
    public CargoStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }
}
