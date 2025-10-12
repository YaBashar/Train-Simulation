package unsw.trains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import unsw.exceptions.InvalidRouteException;
import unsw.exceptions.UNSWException;
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
    private List <Train> trains = new ArrayList<Train>();

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
        
        Station startStation = Station.getStationById(stationId, stations);
        Train train = null;

        if (type.equals("PassengerTrain")) {
            train = new PassengerTrain(trainId, type, stationId, startStation.getPos(), route, tracks);

        } else if (type.equals("CargoTrain")) {
            train = new CargoTrain(trainId, type, stationId, startStation.getPos(), route, tracks);

        } else if (type.equals("BulletTrain")) {
            train = new BulletTrain(trainId, type, stationId, startStation.getPos(), route, tracks);
        }

        trains.add(train);
        try {
            startStation.addTrainToStation(train);
        } catch (UNSWException e) {
            e.printStackTrace();
        }
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
        ArrayList<String> trainList = new ArrayList<>();
        for (Train train: trains) {
            trainList.add(train.getTrainId());
        }
        return trainList;
    }

    public TrainInfoResponse getTrainInfo(String trainId) {

        
        Train findTrain = null;
        for (Train train: trains) {
            if (train.getTrainId().equals(trainId)) {
                findTrain = train;
                break;
            }
        }

        List<LoadInfoResponse> loadInfos = new ArrayList<LoadInfoResponse>();
        List<Load> loads = findTrain.getLoadsOnTrain();
        for (Load load: loads) {
            LoadInfoResponse loadInfo = new LoadInfoResponse(load.getloadId(), load.getType());
            loadInfos.add(loadInfo);
        }

        TrainInfoResponse t = new TrainInfoResponse(trainId, findTrain.getCurrentStation(), findTrain.getType(), findTrain.getCurrentPosition(), loadInfos);
        return t;
    }

    public StationInfoResponse getStationInfo(String stationId) {
        Station findStation = Station.getStationById(stationId, stations);

        List<TrainInfoResponse> trainInfos = new ArrayList<TrainInfoResponse>();
        List<Train> trains = findStation.getTrainsAtStation();
        for (Train train: trains) {
            TrainInfoResponse trainInfo = this.getTrainInfo(train.getTrainId());
            trainInfos.add(trainInfo);
        }

        List<LoadInfoResponse> loadInfos = new ArrayList<LoadInfoResponse>();
        List<Load> loads = findStation.getLoadsAtStation();
        for (Load load: loads) {
            LoadInfoResponse loadInfo = new LoadInfoResponse(load.getloadId(), load.getType());
            loadInfos.add(loadInfo);
        }

        StationInfoResponse s = new StationInfoResponse(stationId, findStation.getType(), findStation.getPos(), loadInfos, trainInfos);
        return s;
    }

    public TrackInfoResponse getTrackInfo(String trackId) {
        Track findTrack = Track.getTrackById(trackId, tracks);
        TrackInfoResponse t = new TrackInfoResponse(trackId, findTrack.getFromStationId(), findTrack.getToStationId(),  TrackType.NORMAL, 10);
        return t;
    }

    public void simulate() {
        // Move train based on ids in lexigraphcial order
        trains.sort(Comparator.comparing(Train:: getTrainId));
        for (Train train: trains) {
           train.move(stations);
        }
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
        // Todo: Task cii
        Station startStation = Station.getStationById(startStationId, stations);
        Load passenger = new Passenger(passengerId, startStation, destStationId);
        // startStation.add(passenger);

        try {
            startStation.addLoadToStation(passenger);
        } catch (UNSWException e) {
            e.printStackTrace();
        }
    }

    public void createCargo(String startStationId, String destStationId, String cargoId, int weight) {
        // Todo: Task bii
        Station startStation = Station.getStationById(startStationId, stations);
        Load cargo = new Cargo(cargoId, startStation, destStationId, weight);
        try {
            startStation.addLoadToStation(cargo);
        } catch (UNSWException e) {
            e.printStackTrace();
        }
    }

    public void createPerishableCargo(String startStationId, String destStationId, String cargoId, int weight,
            int minsTillPerish) {
    
        Station startStation = Station.getStationById(startStationId, stations);
        Load perishableCargo = new PerishableCargo(cargoId, startStation, destStationId, weight, minsTillPerish);

        try {
            startStation.addLoadToStation(perishableCargo);
        } catch (UNSWException e) {
            e.printStackTrace();
        }
    }

    public void createTrack(String trackId, String fromStationId, String toStationId, boolean isBreakable) {
        // Todo: Task ci
    }

    public void createPassenger(String startStationId, String destStationId, String passengerId, boolean isMechanic) {
        
    }
}
