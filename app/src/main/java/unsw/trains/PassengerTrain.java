package unsw.trains;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

/*
 * Holds a maximum of 3500kgs worth of passengers (i.e. 50 passengers).
 * Has a route of stations that must be linear. Cannot travel on cyclical routes
 */

public class PassengerTrain extends Train {

    public PassengerTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) throws InvalidRouteException{
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(2);

        Route trainRoute = super.getRoute();
        boolean isCycle = trainRoute.isCyclical();
        if (isCycle) {
            throw new InvalidRouteException("Invalid");
        }
    }

    @Override
    public void move(List<Station> stations) {

        Route route = this.getRoute();
        List<String> stationIds = route.getStations();
        
        String nextStationId = getNextStation(route, stationIds);
        super.setNewPosition(nextStationId, stations);

    }

    
    public String getNextStation(Route route, List<String> stationIds) {
        if (this.isMoveBackward() == true) {
            if (route.getRouteIndex() > 0) {
                 route.setRouteIndex(route.getRouteIndex() - 1);

            }  else if (route.getRouteIndex() == 0) {
                this.setMoveBackward(false);
                route.setRouteIndex(route.getRouteIndex() + 1);
            }

        } else {

            if (route.getRouteIndex() < stationIds.size() - 1) {
                route.setRouteIndex(route.getRouteIndex() + 1);
            } else {
                this.setMoveBackward(true);
                route.setRouteIndex(route.getRouteIndex() - 1);
            }
        }

        String nextStationId = stationIds.get(route.getRouteIndex());
        return nextStationId;
    }
    
}
