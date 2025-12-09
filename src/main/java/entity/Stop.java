package entity;

public class Stop {
    private Long stopId;
    private String stopName;

    public Stop(Long stopId, String stopName) {
        this.stopId = stopId;
        this.stopName = stopName;
    }

    public Long getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }
}