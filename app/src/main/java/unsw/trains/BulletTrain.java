package unsw.trains;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

public class BulletTrain extends Train {
   
    private final int maxWeightOnBoard = 5000;
    private int currentWeightOnBoard;
    private int totalCargoWeightOnBoard;

     public BulletTrain(String trainId, String type, String stationId, Position pos, List<String> route, TrainSystemData data) throws InvalidRouteException{
        super(trainId, type, stationId, pos, route, data);
        super.setSpeed(5.0);

        this.currentWeightOnBoard = 0;
        this.totalCargoWeightOnBoard = 0;
    }

    @Override
    public void move() {
        Route route = this.getRoute();
        String nextStationId = route.getNextStationLinearAndCyclicalRoute((Train) this);
        super.setNewPosition(nextStationId);
       
    }

    @Override
    public boolean canAcceptLoad(Load load) {
        if (load.getType().equals("Passenger") && this.currentWeightOnBoard <= maxWeightOnBoard) {
            this.currentWeightOnBoard += load.getWeight();
            return true;
        }

        if (load.getType().equals("Cargo") && this.currentWeightOnBoard <= maxWeightOnBoard) {
            this.totalCargoWeightOnBoard += load.getWeight();
            this.currentWeightOnBoard += load.getWeight();

            Cargo cargo = (Cargo) load;
            double newSpeed = cargo.slowDownTrain(totalCargoWeightOnBoard, this.getSpeed());
            this.setSpeed(newSpeed);

            return true;
        }

        return false;
    }

}
