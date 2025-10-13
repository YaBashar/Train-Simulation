package unsw.trains;
import java.util.List;


public abstract class Load {
    
    private String loadId;
    private String type;
    private int weight;
    private String start;
    private String destination;
    
    public Load(String loadId, int weight, String startStation, String destination) {
        this.loadId = loadId;
        this.weight = weight;
        this.destination = destination;
    }

    // Getters and Setters
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getloadId() {
        return loadId;
    }

    public void setloadId(String loadId) {
        this.loadId = loadId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}