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
    private int speed;
    private List<String> stationsInRoute;
    private boolean moveBackward;

    private Route route;
    private List<Load> loadsOnTrain;
    
   

    public Train(String trainId, String type, String stationId, Position pos, List<String> stationsInRoute, List<Track> tracks) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.currentStation = stationId;
        this.stationsInRoute = stationsInRoute;
        this.currentPosition = pos;
        this.moveBackward = false;

        this.route = new Route(stationsInRoute, tracks);
        this.loadsOnTrain = new ArrayList<Load>();
    }

    public abstract void move(List<Station> stations);
    public abstract void embarkLoads(List<Load> loadsOnStation);


    public void setNewPosition(String nextStationId, List<Station> stations) {

        Station currentStation = Station.getStationById(this.currentStation, stations);   
        List<Load> loadsOnStation = currentStation.getLoadsAtStation();
        embarkLoads(loadsOnStation);

        Station nextStation = Station.getStationById(nextStationId, stations);
        Position nextStationPosition = nextStation.getPos();
        Position destination = this.getCurrentPosition().calculateNewPosition(nextStationPosition, this.getSpeed());


        if (this.currentPosition.isInBound(nextStationPosition, this.getSpeed())) {

            try {
                currentStation.removeTrainFromStation(this.getTrainId());
                nextStation.addTrainToStation(this);
            } catch (Exception e) {
                return;
            }

            route.updateRouteIndexOnArrival(this, route, route.getStations());
            disembark(loadsOnTrain, nextStation.getLoadsAtStation(), nextStationId);

            this.setCurrentPosition(nextStationPosition);
            this.setCurrentStation(nextStation.getStationId());
            
        } else {
            this.setCurrentPosition(destination);
        }
    }


    public void disembark(List<Load> loadsOnTrain, List<Load> loadsOnStation, String stationId) {
        
        List<Load> disembarkingLoads = new ArrayList<Load>();
        
        for (Load load: loadsOnTrain) {
            if (load.getDestination().equals(stationId)) {
                loadsOnStation.add(load);
                disembarkingLoads.add(load);
            }
        }

        loadsOnTrain.removeAll(disembarkingLoads);    
    }


    public static Train getTrainById(String trainId, List<Train> trains) {
        
        Train findTrain = null;
        for (Train train: trains) {
            if (train.getTrainId().equals(trainId)) {
                trains.remove(train);
                findTrain = train;
                break;
            }
        }

        return findTrain;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
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
