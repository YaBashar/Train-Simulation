package unsw.trains;
import java.util.List;
import unsw.utils.Position;

/*
 * Holds a maximum of 3500kgs worth of passengers (i.e. 50 passengers).
 * Has a route of stations that must be linear. Cannot travel on cyclical routes
 */

public class PassengerTrain extends Train {

    public PassengerTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(2);
    }
    
}
