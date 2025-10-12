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
    private List<String> stationsInRoute;
    private boolean moveBackward;
    private Route route;
    private List<Load> loadsOnTrain;
    private TrainSystemData data;
    
    public Train(String trainId, String type, String stationId, Position pos, List<String> stationsInRoute, TrainSystemData data) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.currentStation = stationId;
        this.stationsInRoute = stationsInRoute;
        this.currentPosition = pos;
        this.moveBackward = false;

        this.route = new Route(stationsInRoute, data);
        this.loadsOnTrain = new ArrayList<Load>();
        this.data = data;
    }

    public abstract void move();
    public abstract boolean canAcceptLoad(Load load);

    public void setNewPosition(String nextStationId) {
        Station currentStation = data.getStationById(this.currentStation);   
        Station nextStation = data.getStationById(nextStationId);
        currentStation.embarkLoads();

        Position nextStationPosition = nextStation.getPos();
        Position destination = this.getCurrentPosition().calculateNewPosition(nextStationPosition, this.getSpeed());

        if (this.currentPosition.isInBound(nextStationPosition, this.getSpeed())) {
            try {
                currentStation.removeTrainFromStation(this.getTrainId());
                nextStation.addTrainToStation(this);
            } catch (Exception e) {
                return;
            }

            nextStation.disembark(loadsOnTrain, nextStationId);
            route.updateRouteIndexOnArrival(this);
            this.setCurrentPosition(nextStationPosition);
            this.setCurrentStation(nextStation.getStationId()); 
            
        } else {
            this.setCurrentPosition(destination);
        }
    }

    
    // Getters and Setters
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
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


    public void setType(String type) {
        this.type = type;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
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
}
