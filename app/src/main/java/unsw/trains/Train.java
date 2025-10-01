package unsw.trains;
import java.util.List;

import unsw.utils.Position;

 // Need to store current position of route

public class Train {
    private String trainId;
    private String type;
    private String start;
    private String currentStation; // Will need to update this when in between stations and at new stations
    private Position currentPosition;
    private int speed;
    private int routeIndex;
    private List<String> stationsInRoute;
    private boolean moveBackward;

    private Route route;
    
    public Train(String trainId, String type, String stationId, Position pos, List<String> stationsInRoute, List<Track> tracks) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.currentStation = stationId;
        this.stationsInRoute = stationsInRoute;
        this.currentPosition = pos;
        this.moveBackward = false;

        this.route = new Route(stationsInRoute, tracks);
        this.setRouteIndex(0);
    }


    public void move(List<Station> stations) {

        String nextStationId = null;
        Station nextStation;
        Position nextStationPosition;
        Position destination;
        
        // Determine where the next station is based on train's relative position within the route
        // If train is at end of route then we need to determine next station based on type of route
        // If route is cyclical train moves back to start of route
        // If route is linear train moves backwards.
        if (this.getRouteIndex() < this.stationsInRoute.size() - 1 && this.moveBackward == false) {
            nextStationId = this.stationsInRoute.get(this.getRouteIndex() + 1); 

        } else {
            if (this.route.isCyclical(route, start, currentStation)) {
                this.setRouteIndex(0);
                nextStationId = this.stationsInRoute.get(this.getRouteIndex()); 

            } else {
                this.setMoveBackward(true);
            }
        }

        if(this.getRouteIndex() >= 0 && this.moveBackward == true) {
            nextStationId = this.stationsInRoute.get(this.getRouteIndex() - 1); 

        } else {
            this.setMoveBackward(false);
        }

        nextStation = Station.getStationById(nextStationId, stations);
        nextStationPosition = nextStation.getPos();
        destination = this.currentPosition.calculateNewPosition(nextStationPosition, this.speed);
        
        // Determine whether train ends up at next station or in between stations
        if (destination.isInBound(nextStationPosition, speed)) {
            // Check if next Station can hold an inbound train others train stays in current position.
            try {
                nextStation.addTrainToStation(this);
            } catch (Exception e) {
                return;
            }

            this.setCurrentPosition(nextStationPosition);
            this.setCurrentStation(nextStation.getStationId());
            this.setRouteIndex(this.getRouteIndex() + 1);;

        } else {
            // train is in between stations
            this.setCurrentPosition(destination);
            this.setCurrentStation("-"); 
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

    public boolean isMoveBackward() {
        return moveBackward;
    }

    public void setMoveBackward(boolean moveBackward) {
        this.moveBackward = moveBackward;
    }
}
