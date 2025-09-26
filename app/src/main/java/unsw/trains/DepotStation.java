package unsw.trains;
import java.util.List;
import unsw.exceptions.UNSWException;


// A stopping point for trains, but no passengers or cargo can be loaded or unloaded here.

public class DepotStation extends Station {

    private final int maxTrains = 8;

    public DepotStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }

    public List<Train> getTrainsAtStation() {
        return trainsAtStation;
    }

    public void setTrainsAtStation(List<Train> trainsAtStation) {
        this.trainsAtStation = trainsAtStation;
    }

    public void addTrainToStation(Train train) throws UNSWException {
        if (this.trainsAtStation.size() == maxTrains) {
            throw new UNSWException("Train Capacity Exceeded", "Station Error", 404);
        }

        this.trainsAtStation.add(train);
    }

   
}
