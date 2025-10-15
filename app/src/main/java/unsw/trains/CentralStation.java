package unsw.trains;
import java.util.List;
import unsw.exceptions.UNSWException;

// Can have a maximum of 8 trains stopped at it at any given time.
// Can store an unlimited amount of cargo and passengers.

public class CentralStation extends Station {

    private final int maxTrains = 8;

    public CentralStation(String stationId, String type, double x, double y) {
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
    public void addLoadToStation(Load load) {
        List<Load> loadsAtStation = super.getLoadsAtStation();
        super.setLoadsAtStation(loadsAtStation, load);
    }
}
