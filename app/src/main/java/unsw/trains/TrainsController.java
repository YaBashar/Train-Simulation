package unsw.trains;

import java.util.ArrayList;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.response.models.*;
import unsw.utils.TrackType;

/**
 * The controller for the Trains system.
 *
 * The method signatures here are provided for you. Do NOT change the method signatures.
 */
public class TrainsController {

    private List <Station> stations = new ArrayList<Station>();
    private List <Track> tracks = new ArrayList<Track>();

    public void createStation(String stationId, String type, double x, double y) {
        Station station = null;

        if (type.equals("PassengerStation")) {
            station = new PassengerStation(stationId, type, x, y);

        } else if (type.equals("CargoStation")) {
            station = new CargoStation(stationId, type, x, y);

        } else if (type.equals("CentralStation")) {
            station = new CentralStation(stationId, type, x, y);

        } else if (type.equals("DepotStation")) {
            station = new DepotStation(stationId, type, x, y);
        }

        stations.add(station);
    }

    public void createTrack(String trackId, String fromStationId, String toStationId) {
        Track track = new Track(trackId, fromStationId, toStationId);
        tracks.add(track);
    }

    public void createTrain(String trainId, String type, String stationId, List<String> route)
            throws InvalidRouteException {
        // Todo: Task aiii
    }

    public List<String> listStationIds() {
        ArrayList<String> stationList = new ArrayList<>();
        for (Station station: stations) {
            stationList.add(station.getStationId());
        }
        return stationList;
    }

    public List<String> listTrackIds() {
        ArrayList<String> trackList = new ArrayList<>();
        for (Track track: tracks) {
            trackList.add(track.getTrackId());
        }
        return trackList;
    }


    public List<String> listTrainIds() {
        // Todo: Task avi
        return new ArrayList<>();
    }

    public TrainInfoResponse getTrainInfo(String trainId) {
        // Todo: Task avii
        return null;
    }

    public StationInfoResponse getStationInfo(String stationId) {
        Station findStation = null;
        for (Station station: stations) {
            if (station.getStationId().equals(stationId)) {
                findStation = station;
                break;
            }
        }

        StationInfoResponse s = new StationInfoResponse(stationId, findStation.getType(), findStation.getPos());
        return s;
    }

    public TrackInfoResponse getTrackInfo(String trackId) {
        // Todo: Task aix
        Track findTrack = null;
        for (Track track: tracks) {
            if (track.getTrackId().equals(trackId)) {
                findTrack = track;
                break;
            }
        }

        TrackInfoResponse t = new TrackInfoResponse(trackId, findTrack.getFromStationId(), findTrack.getToStationId(),  TrackType.NORMAL, 10);
        return t;
    }

    public void simulate() {
        // Todo: Task bi
    }

    /**
     * Simulate for the specified number of minutes. You should NOT modify
     * this function.
     */
    public void simulate(int numberOfMinutes) {
        for (int i = 0; i < numberOfMinutes; i++) {
            simulate();
        }
    }

    public void createPassenger(String startStationId, String destStationId, String passengerId) {
        // Todo: Task bii
    }

    public void createCargo(String startStationId, String destStationId, String cargoId, int weight) {
        // Todo: Task bii
    }

    public void createPerishableCargo(String startStationId, String destStationId, String cargoId, int weight,
            int minsTillPerish) {
        // Todo: Task biii
    }

    public void createTrack(String trackId, String fromStationId, String toStationId, boolean isBreakable) {
        // Todo: Task ci
    }

    public void createPassenger(String startStationId, String destStationId, String passengerId, boolean isMechanic) {
        // Todo: Task cii
    }
}
