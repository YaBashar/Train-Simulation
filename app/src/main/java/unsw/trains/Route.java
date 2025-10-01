package unsw.trains;

import java.util.List;

public class Route {
    private List<String> stations;
    private List<Track> tracks;

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

    
    // Methods
    public boolean isCyclical(Route route, String firstStationId, String lastStationId) {
        List<Track> tracks = this.getTracks();
        List<String> stations = this.getStations();

        if (stations.size() < 3) {
            return false;
        }
        
        try {
            Track track = Track.getTrackfromStationId(lastStationId, tracks);  
            if (track.getToStationId().equals(firstStationId)) {
                return true;
            }

        } catch (NullPointerException e) {
            return false;
        }
        
        return false;
    }


  


}
