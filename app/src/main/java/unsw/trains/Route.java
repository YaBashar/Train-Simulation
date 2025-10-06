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
}
