package unsw.trains;
import java.util.List;
import unsw.utils.Position;

public class BulletTrain extends Train {
   
    public BulletTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(5);
    }

    @Override
    public void move(List<Station> stations) {

        
        // Can move on cyclical and linear tracks
        Route route = this.getRoute();
        List<String> stationIds = route.getStations();

        if (route.getRouteIndex() < stationIds.size() - 1 && this.isMoveBackward() == false) {
            route.setRouteIndex((route.getRouteIndex() + 1)); 

        } else {

            if (route.isCyclical()) {
                route.setRouteIndex(0);

            } else {
                this.setMoveBackward(true);
            }
        }

        if(route.getRouteIndex() >= 0 && this.isMoveBackward() == true) {
            route.setRouteIndex((route.getRouteIndex() - 1));  

        } else {
            this.setMoveBackward(false);
        }


        String nextStationId = stationIds.get(route.getRouteIndex());
        super.setNewPosition(nextStationId, stations);
       
    }
}
