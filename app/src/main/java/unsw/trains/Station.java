package unsw.trains;
import java.util.List;
import unsw.utils.Position;

// Every Station has a number of trains
// Every Station has either cargo, passengers or both

public class Station {
    private String stationId;
    private String type;
    private Position pos;

    public Station(String stationId, String type, double x, double y) {
        this.stationId = stationId;
        this.type = type;
        this.pos = new Position(x, y);
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }


    public static Station getStationById(String stationId, List<Station> stations) {
        Station findStation = null;
        for (Station station: stations) {
            if (station.getStationId().equals(stationId)) {
                findStation = station;
                break;
            }
        }

        return findStation;
    }
}
