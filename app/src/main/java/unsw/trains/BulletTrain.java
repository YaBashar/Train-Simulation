package unsw.trains;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

public class BulletTrain extends Train implements CarriesCargo {
   
    private final int maxWeightOnBoard = 5000;
   
    public BulletTrain(String trainId, String type, String stationId, Position pos, List<Station> stations) throws InvalidRouteException{
        super(trainId, type, stationId, pos, stations);
        super.setSpeed(5.0);
    }

    @Override
    public void move(Station currentStation) {

        Route route = this.getRoute();
        Station nextStation = route.getNextStationLinearAndCyclicalRoute((Train) this);
        super.setNewPosition(currentStation, nextStation);;

    }

    @Override
    public boolean canAcceptLoad(Load load) {

        int totalWeightOnBoard = this.getTotalWeightOnBoard();
        int totalCargoWeightOnBoard = this.getTotalWeightOnBoard();

        if (load.getType().equals("Passenger") && totalWeightOnBoard + load.getWeight() <= maxWeightOnBoard) {
            totalWeightOnBoard += load.getWeight();
            return true;
        }

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
