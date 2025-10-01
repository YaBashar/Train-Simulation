package unsw.trains;

import java.util.List;

import unsw.utils.Position;


public class CargoTrain extends Train {
    
    public CargoTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(3);
    }


}
