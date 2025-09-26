package unsw.trains;
import java.util.ArrayList;
import java.util.List;
import unsw.exceptions.UNSWException;

// Can store unlimited passengers
// Cannot store cargo.

public class PassengerStation extends Station {

    private List<Train> trainsAtStation;
    private final int maxTrains = 2;

    public PassengerStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
        this.trainsAtStation = new ArrayList<Train>();
    }

    public void addTrainToStation(Train train) throws UNSWException {
        if (trainsAtStation.size() == maxTrains) {
            throw new UNSWException("Train Capacity Exceeded", "Station Error", 404);
        }

        this.trainsAtStation.add(train);
    }


}
