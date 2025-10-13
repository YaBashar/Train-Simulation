package unsw.trains;
import java.util.List;

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
        List<Train> trainsAtStation = super.getTrainsAtStation();
        if (trainsAtStation.size() >= maxTrains) {
            throw new UNSWException("Train Capacity Exceeded", "Station Error", 404);
        }

        super.getTrainsAtStation().add(train);
    }

    @Override
    public void addLoadToStation(Load load) throws UNSWException {
        List<Load> loadsAtStation = super.getLoadsAtStation();
        if (load.getType().equals("Cargo")) {
            throw new UNSWException("This station cannot hold cargo", "Station Error", 404);
        }

        super.setLoadsAtStation(loadsAtStation, load);
    }
}
