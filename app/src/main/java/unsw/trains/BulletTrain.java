package unsw.trains;
import java.util.List;
import unsw.utils.Position;

public class BulletTrain extends Train {
   
    public BulletTrain(String trainId, String type, String stationId, List<String> route, Position pos) {
        super(trainId, type, stationId, route, pos);
        super.setSpeed(5);
    }

}
