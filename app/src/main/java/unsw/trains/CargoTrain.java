package unsw.trains;

import java.util.List;

import unsw.utils.Position;


public class CargoTrain extends Train {
    
    private Number speed;

    public CargoTrain(String trainId, String type, String stationId, List<String> route, Position pos) {
        super(trainId, type, stationId, route, pos);
        this.speed = 3;
    }

    public Number getSpeed() {
        return speed;
    }

    public void setSpeed(Number speed) {
        this.speed = speed;
    }

}
