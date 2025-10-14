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

    private List<Train> trains = new ArrayList<Train>();
    private List<Station> stations = new ArrayList<Station>();
    private List<Track> tracks = new ArrayList<Track>();


    public void createStation(String stationId, String type, double x, double y) {
        if (type.equals("PassengerStation")) {
            Station station = new PassengerStation(stationId, type, x, y);
            stations.add(station);

        } else if (type.equals("CargoStation")) {
            Station station = new CargoStation(stationId, type, x, y);
            stations.add(station);

        } else if (type.equals("CentralStation")) {
            Station station = new CentralStation(stationId, type, x, y);
            stations.add(station);

        } else if (type.equals("DepotStation")) {
            Station station = new DepotStation(stationId, type, x, y);
            stations.add(station);
        }

    }

    public void createTrack(String trackId, String fromStationId, String toStationId) {
        Track track = new Track(trackId, fromStationId, toStationId);

        Station fromStation = getStationById(fromStationId);
        Station toStation = getStationById(toStationId);

        fromStation.getConnectedTracks().add(track.getTrackId());
        toStation.getConnectedTracks().add(track.getTrackId());

        tracks.add(track);
    }

    public void createTrain(String trainId, String type, String stationId, List<String> route)
            throws InvalidRouteException {
        
        Station startStation = getStationById(stationId);

        List<Station> stationsInRoute = new ArrayList<Station>();
        for (String station: route) {
            Station newStation = getStationById(station);
            stationsInRoute.add(newStation);
        }

        Train train;
            
        if (type.equals("PassengerTrain")) {
            train = new PassengerTrain(trainId, type, stationId, startStation.getPos(), stationsInRoute);
            trains.add(train);
        } else if (type.equals("CargoTrain")) {
            train = new CargoTrain(trainId, type, stationId, startStation.getPos(), stationsInRoute);
            trains.add(train);

        } else if (type.equals("BulletTrain")) {
            train = new BulletTrain(trainId, type, stationId, startStation.getPos(), stationsInRoute);
            trains.add(train);
        } else {
            return;
        }

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
        Train findTrain = getTrainById(trainId);
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
        Station findStation = getStationById(stationId);

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
        Track findTrack = getTrackById(trackId);
        TrackInfoResponse t = new TrackInfoResponse(trackId, findTrack.getFromStationId(), findTrack.getToStationId(),  TrackType.NORMAL, 10);
        return t;
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

    public void simulate() {
        // Move train based on ids in lexigraphcial order
        trains.sort(Comparator.comparing(Train:: getTrainId));
        for (Train train: trains) {

           Station currentStation = getStationById(train.getCurrentStation());
           train.move(currentStation);
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
        Station startStation = getStationById(startStationId);
        Load passenger = new Passenger(passengerId, startStationId, destStationId);

        try {
            startStation.addLoadToStation(passenger);
        } catch (UNSWException e) {
            e.printStackTrace();
        }
    }

    public void createCargo(String startStationId, String destStationId, String cargoId, int weight) {
        Station startStation = getStationById(startStationId);
        Load cargo = new Cargo(cargoId, startStationId, destStationId, weight);
        try {
            startStation.addLoadToStation(cargo);
        } catch (UNSWException e) {
            e.printStackTrace();
        }
    }

    public void createPerishableCargo(String startStationId, String destStationId, String cargoId, int weight,
            int minsTillPerish) {
    
        Station startStation = getStationById(startStationId);
        Load perishableCargo = new PerishableCargo(cargoId, startStationId, destStationId, weight, minsTillPerish);

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
