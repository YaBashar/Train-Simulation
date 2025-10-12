package unsw.trains;

import java.util.ArrayList;
import java.util.List;

public class TrainSystemData {
    private List <Station> stations = new ArrayList<Station>();
    private List <Track> tracks = new ArrayList<Track>();
    private List <Train> trains = new ArrayList<Train>();

    public TrainSystemData(List<Station> stations, List<Track> tracks, List<Train> trains) {
        this.stations = stations;
        this.tracks = tracks;
        this.trains = trains;
    }

    
    public Station getStationById(String stationId) {
        Station findStation = null;
        for (Station station: this.stations) {
            if (station.getStationId().equals(stationId)) {
                findStation = station;
                break;
            }
        }

        return findStation;
    }

    public Train getTrainById(String trainId) {   
        Train findTrain = null;
        for (Train train: trains) {
            if (train.getTrainId().equals(trainId)) {
                trains.remove(train);
                findTrain = train;
                break;
            }
        }
        return findTrain;
    }

    public Track getTrackById(String trackId) {
        Track findTrack = null;
        for (Track track: tracks) {
            if (track.getTrackId().equals(trackId)) {
                findTrack = track;
                break;
            }
        }

        return findTrack;
    }

    public Track getTrackfromStationId(String StationId) {
        Track findTrack = null;
        for (Track Track: tracks) {
            if (Track.getFromStationId().equals(StationId)) {
                findTrack = Track;
                break;
            }
        }

        return findTrack;
    }


    public List<Station> getStations() {
        return stations;
    }


    public void addStation(Station station) {
        this.stations.add(station);
    }


    public List<Track> getTracks() {
        return tracks;
    }


    public void addTrack(Track track) {
        this.tracks.add(track);
    }


    public List<Train> getTrains() {
        return trains;
    }


    public void addTrain(Train train) {
        this.trains.add(train);
    }
}
