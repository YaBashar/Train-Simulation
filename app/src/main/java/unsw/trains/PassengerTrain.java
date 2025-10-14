package unsw.trains;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.utils.Position;

/*
 * Holds a maximum of 3500kgs worth of passengers (i.e. 50 passengers).
 * Has a route of stations that must be linear. Cannot travel on cyclical routes
 */

public class PassengerTrain extends Train {

    private final int maxWeightOnBoard = 3500;
 
    public PassengerTrain(String trainId, String type, String stationId, Position pos, List<Station> stations) throws InvalidRouteException{
        super(trainId, type, stationId, pos, stations);
        super.setSpeed(2.0);

        Route trainRoute = super.getRoute();
        boolean isCycle = trainRoute.isCyclical();
        if (isCycle) {
            throw new InvalidRouteException("Invalid");
        }

    }

    @Override
    public void move(Station currentStation) {

        Route route = this.getRoute();
        Station nextStation = route.getNextStationLinearRoute((Train) this);
        super.setNewPosition(currentStation, nextStation);;

    }

    @Override
    public boolean canAcceptLoad(Load load) {

        int totalWeightOnBoard = this.getTotalWeightOnBoard();

        if (load.getType().equals("Passenger") && totalWeightOnBoard + load.getWeight() <= maxWeightOnBoard) {
            totalWeightOnBoard += load.getWeight();
            super.setTotalWeightOnBoard(totalWeightOnBoard);
            
            return true;
        }

        return false;
    }   
}
