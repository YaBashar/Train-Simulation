package unsw.trains;
import java.util.ArrayList;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

/*
 * Can only carry cargo.
 * Holds a maximum of 5000kg of cargo.
 * Speed is slowed depending on how much cargo onboard 
 */

public class CargoTrain extends Train {

    private final int maxWeightOnBoard = 5000;
    private int currentWeightOnBoard;

    public int getCurrentWeightOnBoard() {
        return currentWeightOnBoard;
    }

    public void setCurrentWeightOnBoard(int currentWeightOnBoard) {
        this.currentWeightOnBoard = currentWeightOnBoard;
    }
    
    public CargoTrain(String trainId, String type, String stationId, Position pos, List<String> route, List<Track> tracks) throws InvalidRouteException {
        super(trainId, type, stationId, pos, route, tracks);
        super.setSpeed(3);

        Route trainRoute = super.getRoute();
        boolean isCycle = trainRoute.isCyclical();
        if (isCycle) {
            throw new InvalidRouteException("Invalid");
        }
    }

    @Override
    public void move(List<Station> stations)  {

        Route route = this.getRoute();
        List<String> stationIds = route.getStations();
        
        String nextStationId = route.getNextStationLinearRoute((Train) this, route, stationIds);
        super.setNewPosition(nextStationId, stations);
    }

    @Override
    public boolean canAcceptLoad(Load load) {
        if (load.getType().equals("Cargo") && this.currentWeightOnBoard <= maxWeightOnBoard) {
            this.currentWeightOnBoard += load.getWeight();
            return true;
        }

        return false;
    }
}
