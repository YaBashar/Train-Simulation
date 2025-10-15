package unsw.trains;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

/*
 * Can only carry cargo.
 * Holds a maximum of 5000kg of cargo.
 * Speed is slowed depending on how much cargo onboard
 */

public class CargoTrain extends Train implements CarriesCargo {

    private final int maxWeightOnBoard = 5000;

    public CargoTrain(String trainId, String type, String stationId, Position pos, List<Station> stations)
    throws InvalidRouteException {
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
        super.setNewPosition(currentStation, nextStation);

    }

    @Override
    public boolean canAcceptLoad(Load load) {

        int totalWeightOnBoard = this.getTotalWeightOnBoard();
        int totalCargoWeightOnBoard = this.getTotalWeightOnBoard();

        if (load.getType().equals("Cargo") && totalWeightOnBoard + load.getWeight() <= maxWeightOnBoard) {
            totalWeightOnBoard += load.getWeight();
            totalCargoWeightOnBoard += load.getWeight();

            super.setTotalCargoWeightOnBoard(totalCargoWeightOnBoard);
            super.setTotalCargoWeightOnBoard(totalWeightOnBoard);

            double newSpeed = recalculateSpeed(totalCargoWeightOnBoard, super.getSpeed());
            super.setSpeed(newSpeed);

            return true;
        }

        if (load.getType().equals("PerishableCargo") && totalWeightOnBoard + load.getWeight() <= maxWeightOnBoard) {
            PerishableCargo cargo = (PerishableCargo) load;

            if (cargo.canTakePerishableCargo((Train) this)) {

                totalWeightOnBoard += load.getWeight();
                totalCargoWeightOnBoard += load.getWeight();

                super.setTotalCargoWeightOnBoard(totalCargoWeightOnBoard);
                super.setTotalCargoWeightOnBoard(totalWeightOnBoard);

                double newSpeed = recalculateSpeed(totalCargoWeightOnBoard, super.getSpeed());
                super.setSpeed(newSpeed);

                return true;

            } else {
                return false;
            }
        }

        return false;
    }

    public double recalculateSpeed(int totalCargoWeightOnBoard, double speed) {
        double slowDownFactor = (double) totalCargoWeightOnBoard * 0.01;
        double newSpeed = (100 - slowDownFactor) * speed / 100;
        return newSpeed;
    }
}
