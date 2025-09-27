package unsw.trains;
import java.util.List;

import unsw.exceptions.UNSWException;
import unsw.utils.Position;

 // Need to store current position of route

public class Train {
    private String trainId;
    private String type;
    private String start;
    private String currentStation; // Will need to update this when in between stations and at new stations
    private Position currentPosition;
    private int speed;
    private int routeIndex = 0;
    private List<String> route;
    
    public Train(String trainId, String type, String stationId, List<String> route, Position pos) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.currentStation = stationId;
        this.route = route;
        this.currentPosition = pos;
    }

    public void moveForward(List<Station> stations) {
        Station nextStation = Station.getStationById(route.get(this.routeIndex + 1), stations);
        Position nextStationPosition = nextStation.getPos();
        Position destination = this.currentPosition.calculateNewPosition(nextStationPosition, this.speed);
        
        if (destination.isInBound(nextStationPosition, speed)) {
            // Check if next Station can hold an inbound train others train stays in current position.
            try {
                nextStation.addTrainToStation(this);
            } catch (Exception e) {
                return;
            }

            this.setCurrentPosition(nextStationPosition);
            this.currentStation = nextStation.getStationId();
            this.routeIndex += 1;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void setType(String type) {
        this.type = type;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
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

    public int getRouteIndex() {
        return routeIndex;
    }

    public void setRouteIndex(int routeIndex) {
        this.routeIndex = routeIndex;
    }
}
