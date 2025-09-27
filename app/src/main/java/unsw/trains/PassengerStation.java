package unsw.trains;
import unsw.exceptions.UNSWException;

// Can store unlimited passengers
// Cannot store cargo.

public class PassengerStation extends Station {

    private final int maxTrains = 2;

    public PassengerStation(String stationId, String type, double x, double y) {
        super(stationId, type, x, y);
    }

    @Override
    public void addTrainToStation(Train train) throws UNSWException {
        if (this.trainsAtStation.size() >= maxTrains) {
            throw new UNSWException("Train Capacity Exceeded", "Station Error", 404);
        }

        this.trainsAtStation.add(train);
    }


}
