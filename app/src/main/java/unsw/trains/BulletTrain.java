package unsw.trains;
import java.util.ArrayList;
import java.util.List;
import unsw.utils.Position;

public class BulletTrain extends Train {
   
    private final int maxWeightOnBoard = 5000;
    private int currentWeightOnBoard;

    public BulletTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(5);
    }

    @Override
    public void move(List<Station> stations) {
        Route route = this.getRoute();
        List<String> stationIds = route.getStations();

        String nextStationId = route.getNextStationLinearAndCyclicalRoute((Train) this, route, stationIds);
        super.setNewPosition(nextStationId, stations);
       
    }

    @Override 
    public void embarkLoads(List<Load> loadsOnStation) {
        
        List<Load> boardedLoads = new ArrayList<>();
        for (Load load: loadsOnStation) {
            if (this.currentWeightOnBoard < this.maxWeightOnBoard) {
                super.setLoadsOnTrain(load);
                boardedLoads.add(load);
                this.currentWeightOnBoard += load.getWeight();
            }
        }

        loadsOnStation.removeAll(boardedLoads);
    }

    public int getCurrentWeightOnBoard() {
        return currentWeightOnBoard;
    }

    public void setCurrentWeightOnBoard(int currentWeightOnBoard) {
        this.currentWeightOnBoard = currentWeightOnBoard;
    }
    
}
