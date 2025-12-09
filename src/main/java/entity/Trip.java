package entity;

import java.time.LocalDateTime;

public class Trip {
    private Long tripID;
    private LocalDateTime time;
    private Route route;

    public Trip(Long tripID, LocalDateTime time, Route route) {
        this.tripID = tripID;
        this.time = time;
        this.route = route;
    }

    public Long getTripID() {
        return tripID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Route getRoute() {
        return route;
    }
}
