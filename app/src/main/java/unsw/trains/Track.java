package unsw.trains;

public class Track {
    private String trackId;
    private String fromStationId;
    private String toStationId;

    public Track(String trackId, String fromStationId, String toStationId) {
        this.trackId = trackId;
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getFromStationId() {
        return fromStationId;
    }

    public String getToStationId() {
        return toStationId;
    }
}
