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

        String nextStationId = route.getNextStationLinearAndCyclicalRoute((Train) this, route, stationIds);
        super.setNewPosition(nextStationId, stations);
       
    }
}
