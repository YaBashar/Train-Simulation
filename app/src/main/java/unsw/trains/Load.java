package unsw.trains;

import java.util.List;

import unsw.utils.Position;

public abstract class Load {
    
    private String loadId;
    private String type;
    private int weight;
    private Position currentPosition;
    private String destination;
    
    public Load(String loadId, int weight, Position currentPosition, String destination) {
        this.loadId = loadId;
        this.weight = weight;
        this.currentPosition = currentPosition;
        this.destination = destination;
        this.type = type;
    }

    public static Load getLoadById(String loadId, List<Load> loads) {
        Load findload = null;
        for (Load load: loads) {
            if (load.getloadId().equals(loadId)) {
                findload = load;
                break;
            }
        }

        return findload;
    }

    // Getters and Setters
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
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