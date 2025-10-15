package unsw.trains;
import java.util.List;
import unsw.exceptions.UNSWException;


// A stopping point for trains, but no passengers or cargo can be loaded or unloaded here.

public class DepotStation extends Station {

    private final int maxTrains = 8;

    public DepotStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }

    @Override
    public void addTrainToStation(Train train) throws UNSWException {
        List<Train> trainsAtStation = super.getTrainsAtStation();
        if (trainsAtStation.size() >= maxTrains) {
            throw new UNSWException("Train Capacity Exceeded", "Station Error", 404);
        }

        super.getTrainsAtStation().add(train);
    }

    @Override
    public void addLoadToStation(Load load) throws UNSWException {
        // leave empty or maybe throw exception.
    }

    @Override
    public void embarkLoads() {
        // do nothing
    }

    @Override
    public void disembark(List<Load> loadsOnTrain) {
        //do nothing
    }
}
