package unsw.trains;
import java.util.List;
import unsw.utils.Position;

public class BulletTrain extends Train {
    private Number speed;

    public BulletTrain(String trainId, String type, String stationId, List<String> route, Position pos) {
        super(trainId, type, stationId, route, pos);
        this.speed = 5;
    }

    public Number getSpeed() {
        return speed;
    }

    public void setSpeed(Number speed) {
        this.speed = speed;
    }
}
