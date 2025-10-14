package unsw.trains;

import unsw.utils.Position;

public class PerishableCargo extends Cargo {

    private int minsToPerish;

    public PerishableCargo(String cargoId, String startStation, String destStation, int weight, int minsToPerish) {
        super(cargoId, startStation, destStation, weight);
        super.setType("PerishableCargo");
        this.minsToPerish = minsToPerish;
    }

    public void deteriorate() {
        this.minsToPerish -= 1;
    }

    public int getMinsToPerish() {
        return minsToPerish;
    }

    public void setMinsToPerish(int minsToPerish) {
        this.minsToPerish = minsToPerish;
    }


    public boolean canTakePerishableCargo(Train train) {
        
        Route route = train.getRoute();
        Position currentPosition = train.getCurrentPosition();
        String currentStation = train.getCurrentStation();

        int startingRouteIndex = route.getRouteIndex();

        while (currentStation != this.getDestination()) {
            
            Station nextStation = route.getNextStationLinearRoute(train);
            Position nextStationPosition = nextStation.getPos();
            Position destination = currentPosition.calculateNewPosition(nextStationPosition, train.getSpeed());

            if (currentPosition.isInBound(nextStationPosition, train.getSpeed())) {
                currentStation = nextStation.getStationId();
                currentPosition = nextStationPosition;
                route.updateRouteIndexOnArrival(train);
            } else {
                currentPosition = destination;
            }

            this.deteriorate();
            if (this.getMinsToPerish() <= 0) {
                return false;
            }
        }

        route.setRouteIndex(startingRouteIndex);
        return true;
    }

}
