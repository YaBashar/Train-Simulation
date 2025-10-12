package unsw.trains;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

/*
 * Can only carry cargo.
 * Holds a maximum of 5000kg of cargo.
 * Speed is slowed depending on how much cargo onboard 
 */

public class CargoTrain extends Train {

    private final int maxWeightOnBoard = 5000;
    private int currentWeightOnBoard;

    public int getCurrentWeightOnBoard() {
        return currentWeightOnBoard;
    }

    public void setCurrentWeightOnBoard(int currentWeightOnBoard) {
        this.currentWeightOnBoard = currentWeightOnBoard;
    }
    
    public CargoTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) throws InvalidRouteException {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(3.0);

        Route trainRoute = super.getRoute();
        boolean isCycle = trainRoute.isCyclical();
        if (isCycle) {
            throw new InvalidRouteException("Invalid");
        }
    }

    @Override
    public void move(List<Station> stations)  {

        Route route = this.getRoute();
        String nextStationId = route.getNextStationLinearRoute((Train) this);
        super.setNewPosition(nextStationId, stations);
    }

    @Override
    public boolean canAcceptLoad(Load load) {
        if (load.getType().equals("Cargo") && this.currentWeightOnBoard <= maxWeightOnBoard) {            
            this.currentWeightOnBoard += load.getWeight();

            Cargo cargo = (Cargo) load;
            double newSpeed = cargo.slowDownTrain(currentWeightOnBoard, this.getSpeed());
            setSpeed(newSpeed);

            return true;
        }

        return false;
    }

}
