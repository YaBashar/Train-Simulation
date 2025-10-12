package unsw.trains;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import unsw.exceptions.UNSWException;
import unsw.utils.Position;

// Every Station has a number of trains
// Every Station has either cargo, passengers or both

public abstract class Station {
    private String stationId;
    private String type;
    private Position pos;
    private List<Train> trainsAtStation = new ArrayList<Train>();
    private List<Load> loadsAtStation = new ArrayList<Load>();
    private TrainSystemData data;

    public Station(String stationId, String type, double x, double y, TrainSystemData data) {
        this.stationId = stationId;
        this.type = type;
        this.pos = new Position(x, y);
        this.data = data;
    }

    public abstract void addLoadToStation(Load load) throws UNSWException;
    public abstract void addTrainToStation(Train train) throws UNSWException;

    
    public void embarkLoads() {
        List<Load> embarkedLoads = new ArrayList<>();
        trainsAtStation.sort(Comparator.comparing(Train:: getTrainId));
        loadsAtStation.sort(Comparator.comparing(Load:: getloadId));

        for (Train train: trainsAtStation) {
            for (Load load: loadsAtStation) {
                if (train.canAcceptLoad(load)) {
                    train.getLoadsOnTrain().add(load);
                    embarkedLoads.add(load);
                }
            }    
        }
        this.loadsAtStation.removeAll(embarkedLoads);
    }
    
    public void disembark(List<Load> loadsOnTrain, String stationId) {
        List<Load> disembarkingLoads = new ArrayList<Load>();
        for (Load load: loadsOnTrain) {
            if (load.getDestination().equals(stationId)) {
                this.loadsAtStation.add(load);
                disembarkingLoads.add(load);
            }
        }
        loadsOnTrain.removeAll(disembarkingLoads);    
    }

    public void removeTrainFromStation(String trainId) {
        Train findTrain = data.getTrainById(trainId);
        disembark(findTrain.getLoadsOnTrain(), trainId);
        this.trainsAtStation.remove(findTrain);
    }
    


    // getters and setters
    
    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public List<Train> getTrainsAtStation() {
        return trainsAtStation;
    }

    public void setTrainsAtStation(List<Train> trainsAtStation, Train train) {
        this.trainsAtStation.add(train);
    }

    public List<Load> getLoadsAtStation() {
        return loadsAtStation;
    }

    public void setLoadsAtStation(List<Load> loadsAtStation, Load load) {
        this.loadsAtStation.add(load);
    }


   
}
