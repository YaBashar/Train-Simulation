package unsw.trains;

import java.util.List;

public class Route {
    private List<String> stations;
    private List<Track> tracks;
    private int routeIndex;

    public Route(List<String> stationIds, List<Track> tracks) {
        this.stations = stationIds;
        this.tracks = tracks;
    }

    
    public List<Track> getTracks() {
        return tracks;
    }

    public List<String> getStations() {
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
        List<Track> tracks = this.getTracks();
        List<String> stations = this.getStations();

        if (stations.size() < 3) {
            return false;
        }
        
        // Wrapped in NullPointer try catch as track can equal null if not cyclical
        try {
            String lastStationId = stations.get(stations.size() - 1);
            String firstStationId = stations.get(0);

            Track track = Track.getTrackfromStationId(lastStationId, tracks);  
            if (track.getToStationId().equals(firstStationId)) {
                return true;
            }

        } catch (NullPointerException e) {
            return false;
        }
        
        return false;
    }

    public boolean isLinear() {
        List<String> stations = this.getStations();

        if (stations.size() < 2 || this.isCyclical() == true) {
            return false;
        }

        return true;
    }


    public int calculateNextIndexLinearRoute(Train train, Route route, List<String> stationIds) {
        int currentIndex = route.getRouteIndex();
        int nextIndex = 0;
        
        if (train.isMoveBackward() == true) {
            if (currentIndex > 0) {
                nextIndex = currentIndex - 1;

            }  else if (route.getRouteIndex() == 0) {
                train.setMoveBackward(false);
                nextIndex = currentIndex + 1;
            }

        } else {

            if (route.getRouteIndex() < stationIds.size() - 1) {
                nextIndex = currentIndex + 1;
            } else {
                train.setMoveBackward(true);
                nextIndex = currentIndex - 1;
            }
        }

        return nextIndex;
    }

    public String getNextStationLinearRoute(Train train, Route route, List<String> stationIds) {
        int nextIndex = calculateNextIndexLinearRoute(train, route, stationIds);
        String nextStationId = stationIds.get(nextIndex);
        return nextStationId;
    }

    public void updateRouteIndexOnArrival(Train train, Route route, List<String> stationIds) {
        
        int nextIndex = 0;

        if (train instanceof PassengerTrain || train instanceof CargoTrain) {
            nextIndex = calculateNextIndexLinearRoute(train, route, stationIds);

        } else if (train instanceof BulletTrain) {
            nextIndex = calculateNextIndexLinearAndCyclicalRoute(train, route, stationIds);
        }

        route.setRouteIndex(nextIndex);
    }


    public int calculateNextIndexLinearAndCyclicalRoute(Train train, Route route, List<String> stationIds) {
        
        int currentIndex = route.getRouteIndex();
        int nextIndex = 0;
        
        if (route.isLinear()) {
            nextIndex = calculateNextIndexLinearRoute(train, route, stationIds);
        
        } else {
            
            if (currentIndex >= stationIds.size() - 1) {
                nextIndex = 0;
            } else {
                nextIndex = currentIndex + 1;
            }
        }

        return nextIndex;
    }

    public String getNextStationLinearAndCyclicalRoute(Train train, Route route, List<String> stationIds) {
        int nextIndex = calculateNextIndexLinearAndCyclicalRoute(train, route, stationIds);
        String nextStationId = stationIds.get(nextIndex);
        return nextStationId;
    }
}
