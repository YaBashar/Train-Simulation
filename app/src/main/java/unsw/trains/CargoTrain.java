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
    
    public CargoTrain(String trainId, String type, String stationId, Position pos, List<Station> stations) throws InvalidRouteException{
        super(trainId, type, stationId, pos, stations);
        super.setSpeed(3.0);

        Route trainRoute = super.getRoute();
        boolean isCycle = trainRoute.isCyclical();
        if (isCycle) {
            throw new InvalidRouteException("Invalid");
        }
    }

    @Override
    public void move(Station currentStation) {

        Route route = this.getRoute();
        Station nextStation = route.getNextStationLinearRoute((Train) this);
        super.setNewPosition(currentStation, nextStation);;

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

        if (load.getType().equals("PerishableCargo") && this.currentWeightOnBoard <= maxWeightOnBoard) {
            PerishableCargo cargo = (PerishableCargo) load;

            if (cargo.canTakePerishableCargo((Train) this)) {

                double newSpeed = cargo.slowDownTrain(currentWeightOnBoard, this.getSpeed());
                setSpeed(newSpeed);

                return true;
            } else {
                return false;
            }
        }

        return false;
    }

}
