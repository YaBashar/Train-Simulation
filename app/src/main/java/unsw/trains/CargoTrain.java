package unsw.trains;
import java.util.List;
import unsw.utils.Position;


public class CargoTrain extends Train {
    
    public CargoTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(3);
    }

     @Override
    public void move(List<Station> stations)  {

        Route route = this.getRoute();
        List<String> stationIds = route.getStations();
        
        // boolean isCycle = route.isCyclical();
        // if (isCycle) {
        //     throw new InvalidRouteException("Invalid");
        // }


        String nextStationId = getNextStation(route, stationIds);
        super.setNewPosition(nextStationId, stations);
    }

    // Can only travel linearly.
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
