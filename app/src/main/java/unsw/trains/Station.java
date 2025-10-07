package unsw.trains;
import java.util.ArrayList;
import java.util.List;

import unsw.exceptions.UNSWException;
import unsw.utils.Position;

// Every Station has a number of trains
// Every Station has either cargo, passengers or both

public abstract class Station {
    private String stationId;
    private String type;
    private Position pos;
    private List<Train> trainsAtStation = new ArrayList<Train>();

    public Station(String stationId, String type, double x, double y) {
        this.stationId = stationId;
        this.type = type;
        this.pos = new Position(x, y);
    }

    public abstract void addTrainToStation(Train train) throws UNSWException;

    public void removeTrainFromStation(String trainId) {
        Train findTrain = Train.getTrainById(trainId, trainsAtStation);
        this.trainsAtStation.remove(findTrain);
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

    public List<Train> getTrainsAtStation() {
        return trainsAtStation;
    }

    public void setTrainsAtStation(List<Train> trainsAtStation, Train train) {
        this.trainsAtStation.add(train);
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
