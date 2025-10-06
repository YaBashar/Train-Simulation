package unsw.trains;
import java.util.List;
import unsw.utils.Position;

 // Need to store current position of route

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
    
    public Train(String trainId, String type, String stationId, Position pos, List<String> stationsInRoute, List<Track> tracks) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.currentStation = stationId;
        this.stationsInRoute = stationsInRoute;
        this.currentPosition = pos;
        this.moveBackward = false;

        this.route = new Route(stationsInRoute, tracks);
    }

    public void move(List<Station> stations) {
    }

    // need to remove train from previous station
    public void setNewPosition(String nextStationId, List<Station> stations) {

        Station currentStation = Station.getStationById(this.currentStation, stations);
        Station nextStation = Station.getStationById(nextStationId, stations);
        
        Position nextStationPosition = nextStation.getPos();
        Position destination = this.getCurrentPosition().calculateNewPosition(nextStationPosition, this.getSpeed());

        // Determine whether train ends up at next station or in between stations
        if (destination.isInBound(nextStationPosition, this.getSpeed())) {
            // Check if next Station can hold an inbound train others train stays in current position.
            try {
                currentStation.removeTrainFromStation(this.getTrainId());
                nextStation.addTrainToStation(this);
            } catch (Exception e) {
                return;
            }

            this.setCurrentPosition(nextStationPosition);
            this.setCurrentStation(nextStation.getStationId());
            route.setRouteIndex(route.getRouteIndex());;

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


    public boolean isMoveBackward() {
        return moveBackward;
    }

    public void setMoveBackward(boolean moveBackward) {
        this.moveBackward = moveBackward;
    }


    public Route getRoute() {
        return route;
    }

   

}
