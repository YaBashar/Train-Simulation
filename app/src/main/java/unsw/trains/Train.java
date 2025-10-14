package unsw.trains;
import java.util.ArrayList;
import java.util.List;

import unsw.utils.Position;


public abstract class Train {
    private String trainId;
    private String type;
    private String start;
    private String currentStation; 
    private Position currentPosition;
    private double speed;
    private boolean moveBackward;
    private boolean isRecalculateSpeed;
    private Route route;
    private List<Load> loadsOnTrain;

    private int totalCargoWeightOnBoard;
    private int totalWeightOnBoard;
    
    
    public Train(String trainId, String type, String stationId, Position pos, List<Station> stations) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.currentStation = stationId;
        this.currentPosition = pos;
        this.moveBackward = false;

        this.route = new Route(stations);
        this.loadsOnTrain = new ArrayList<Load>();
        this.isRecalculateSpeed = false;
        this.totalCargoWeightOnBoard = 0;
        this.totalWeightOnBoard = 0;
    }

    public abstract void move(Station currentStation);
    public abstract boolean canAcceptLoad(Load load);

    public void setNewPosition(Station currentStation, Station nextStation) {
        
        currentStation.embarkLoads();

        Position nextStationPosition = nextStation.getPos();
        Position destination = this.getCurrentPosition().calculateNewPosition(nextStationPosition, this.getSpeed());

        if (isRecalculateSpeed && this instanceof CarriesCargo) {
            CarriesCargo train = (CarriesCargo) this;
            double newSpeed = train.recalculateSpeed(totalCargoWeightOnBoard, speed);
            setSpeed(newSpeed);
            isRecalculateSpeed = false;
        }

        if (this.currentPosition.isInBound(nextStationPosition, this.getSpeed())) {
            try {
                currentStation.removeTrainFromStation(this);
                nextStation.addTrainToStation(this);
            } catch (Exception e) {
                return;
            }

            nextStation.disembark(loadsOnTrain);
            route.updateRouteIndexOnArrival(this);
            this.setCurrentPosition(nextStationPosition);
            this.setCurrentStation(nextStation.getStationId()); 
            
        } else {
            this.setCurrentPosition(destination);
        }

        // if any perishable cargo expired remove
        removeExpiredCargo();
        setRecalculateSpeed(true);
    }

    public void removeExpiredCargo() {
        for (Load load: loadsOnTrain) {
            if (load.getType().equals("PerishableCargo")) {
                PerishableCargo cargo = (PerishableCargo) load;
                if (cargo.getMinsToPerish() == 0) {
                    loadsOnTrain.remove(cargo);

                    totalCargoWeightOnBoard -= load.getWeight();
                    totalWeightOnBoard -= load.getWeight();
                }
            }
        }
    }

    
    // Getters and Setters
    public String getTrainId() {
        return trainId;
    }

    public String getType() {
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position pos) {
        this.currentPosition = pos;
    }

    public String getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(String currentStation) {
        this.currentStation = currentStation;
    }


    public boolean isMoveBackward() {
        return moveBackward;
    }

    public void setMoveBackward(boolean moveBackward) {
        this.moveBackward = moveBackward;
    }


    public Route getRoute() {
        return route;
    }

     public List<Load> getLoadsOnTrain() {
        return loadsOnTrain;
    }

    public void setLoadsOnTrain(Load load) {
        this.loadsOnTrain.add(load);
    }

    public boolean isRecalculateSpeed() {
        return isRecalculateSpeed;
    }

    public void setRecalculateSpeed(boolean recalculateSpeed) {
        this.isRecalculateSpeed = recalculateSpeed;
    }

    public int getTotalCargoWeightOnBoard() {
        return totalCargoWeightOnBoard;
    }

    public void setTotalCargoWeightOnBoard(int totalCargoWeightOnBoard) {
        this.totalCargoWeightOnBoard = totalCargoWeightOnBoard;
    }

    public int getTotalWeightOnBoard() {
        return totalWeightOnBoard;
    }

    public void setTotalWeightOnBoard(int totalWeightOnBoard) {
        this.totalWeightOnBoard = totalWeightOnBoard;
    }
}
