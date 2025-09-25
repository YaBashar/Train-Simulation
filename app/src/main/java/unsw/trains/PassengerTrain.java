package unsw.trains;
import java.util.List;
import unsw.utils.Position;

/*
 * Holds a maximum of 3500kgs worth of passengers (i.e. 50 passengers).
 * Has a route of stations that must be linear. Cannot travel on cyclical routes
 */

public class PassengerTrain extends Train {

    private Number speed;

    public PassengerTrain(String trainId, String type, String stationId, List<String> route, Position pos) {
        super(trainId, type, stationId, route, pos);
        this.speed = 2;
    }

    public Number getSpeed() {
        return speed;
    }

    public void setSpeed(Number speed) {
        this.speed = speed;
    }

}
