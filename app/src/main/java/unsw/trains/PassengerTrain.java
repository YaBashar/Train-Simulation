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
        
        String nextStationId = route.getNextStationLinearRoute((Train) this, route, stationIds);
        super.setNewPosition(nextStationId, stations);

    }

    
    
    
}
