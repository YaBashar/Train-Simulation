package unsw.trains;
import java.util.List;

import unsw.utils.Position;


public class Train {
    private String trainId;
    private String type;
    private String start;
    private Position pos;

    private List<String> route;
    
    public Train(String trainId, String type, String stationId, List<String> route, Position pos) {
        this.trainId = trainId;
        this.type = type;
        this.start = stationId;
        this.route = route;
        this.pos = pos;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}
