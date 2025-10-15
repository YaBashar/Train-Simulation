package unsw.trains;

import java.util.List;

public class Route {
    private List<Station> stations;
    private int routeIndex;

    public Route(List<Station> stations) {
        this.stations = stations;
        this.routeIndex = 0;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getRouteIndex() {
        return routeIndex;
    }


    public void setRouteIndex(int routeIndex) {
        this.routeIndex = routeIndex;
    }



    // Methods
    public boolean isCyclical() {
        List<Station> stations = this.getStations();

        if (stations.size() < 3) {
            return false;
        }

        // Wrapped in NullPointer try catch as track can equal null if not cyclical
        try {

            Station lastStation = stations.get(stations.size() - 1);
            Station firstStation = stations.get(0);

            List<String> tracksAtFirstStation = firstStation.getConnectedTracks();
            List<String> tracksAtLastStation = lastStation.getConnectedTracks();

            for (String trackId1 : tracksAtFirstStation) {
                for (String trackId2 : tracksAtLastStation) {
                    if (trackId1.equals(trackId2)) {
                        return true;
                    }
                }
            }

        } catch (NullPointerException e) {
            return false;
        }

        return false;
    }

    public boolean isLinear() {
        List<Station> stations = this.getStations();

        if (stations.size() < 3 || this.isCyclical()) {
            return false;
        }

        return true;
    }


    public int calculateNextIndexLinearRoute(Train train) {
        int currentIndex = this.getRouteIndex();
        int nextIndex = 0;

        if (train.isMoveBackward()) {
            if (currentIndex > 0) {
                nextIndex = currentIndex - 1;

            }  else if (this.getRouteIndex() == 0) {
                train.setMoveBackward(false);
                nextIndex = currentIndex + 1;
            }

        } else {

            if (this.getRouteIndex() < this.stations.size() - 1) {
                nextIndex = currentIndex + 1;
            } else {
                train.setMoveBackward(true);
                nextIndex = currentIndex - 1;
            }
        }

        return nextIndex;
    }

    public Station getNextStationLinearRoute(Train train) {
        int nextIndex = calculateNextIndexLinearRoute(train);
        Station nextStationId = stations.get(nextIndex);
        return nextStationId;
    }


    public int calculateNextIndexLinearAndCyclicalRoute(Train train) {
        int currentIndex = this.getRouteIndex();
        int nextIndex = 0;

        if (this.isLinear()) {
            nextIndex = calculateNextIndexLinearRoute(train);
        } else {
            if (currentIndex >= stations.size() - 1) {
                nextIndex = 0;
            } else {
                nextIndex = currentIndex + 1;
            }
        }
        return nextIndex;
    }

    public Station getNextStationLinearAndCyclicalRoute(Train train) {
        int nextIndex = calculateNextIndexLinearAndCyclicalRoute(train);
        Station nextStationId = stations.get(nextIndex);
        return nextStationId;
    }


    public void updateRouteIndexOnArrival(Train train) {
        int nextIndex = 0;
        if (train instanceof PassengerTrain || train instanceof CargoTrain) {
            nextIndex = calculateNextIndexLinearRoute(train);
        } else if (train instanceof BulletTrain) {
            nextIndex = calculateNextIndexLinearAndCyclicalRoute(train);
        }
        this.setRouteIndex(nextIndex);
    }
}
