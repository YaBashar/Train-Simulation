package unsw.trains;
import java.util.List;
import unsw.exceptions.UNSWException;

// Can store unlimited cargo
// Cannot store passengers

public class CargoStation  extends Station {
    private final int maxTrains = 4;

    public CargoStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }

    public List<Train> getTrainsAtStation() {
        return trainsAtStation;
    }

    public void setTrainsAtStation(List<Train> trainsAtStation) {
        this.trainsAtStation = trainsAtStation;
    }

    @Override
    public void addTrainToStation(Train train) throws UNSWException {
        if (this.trainsAtStation.size() >= maxTrains) {
            throw new UNSWException("Train Capacity Exceeded", "Station Error", 404);
        }

        this.trainsAtStation.add(train);
    }
}
