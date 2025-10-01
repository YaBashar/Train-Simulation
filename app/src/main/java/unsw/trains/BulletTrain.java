package unsw.trains;
import java.util.List;
import unsw.utils.Position;

public class BulletTrain extends Train {
   
    public BulletTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(5);
    }

}
