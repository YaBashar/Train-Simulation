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

    public String getNextStationLinearRoute(Train train, Route route, List<String> stationIds) {
        if (train.isMoveBackward() == true) {
            if (route.getRouteIndex() > 0) {
                 route.setRouteIndex(route.getRouteIndex() - 1);

            }  else if (route.getRouteIndex() == 0) {
                train.setMoveBackward(false);
                route.setRouteIndex(route.getRouteIndex() + 1);
            }

        } else {

            if (route.getRouteIndex() < stationIds.size() - 1) {
                route.setRouteIndex(route.getRouteIndex() + 1);
            } else {
                train.setMoveBackward(true);
                route.setRouteIndex(route.getRouteIndex() - 1);
            }
        }

        String nextStationId = stationIds.get(route.getRouteIndex());
        return nextStationId;
    }

    public String getNextStationLinearAndCyclicalRoute(Train train, Route route, List<String> stationIds) {
        if (route.getRouteIndex() < stationIds.size() - 1 && train.isMoveBackward() == false) {
            route.setRouteIndex((route.getRouteIndex() + 1)); 

        } else {

            if (route.isCyclical()) {
                route.setRouteIndex(0);

            } else {
                train.setMoveBackward(true);
            }
        }

        if(route.getRouteIndex() >= 0 && train.isMoveBackward() == true) {
            route.setRouteIndex((route.getRouteIndex() - 1));  

        } else {
            train.setMoveBackward(false);
        }

        return stationIds.get(route.getRouteIndex());
    }
}
