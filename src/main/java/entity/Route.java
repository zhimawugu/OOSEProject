package entity;

import java.util.List;

public class Route {
    private Long routeID;
    private String name;
    private List<Stop> stops;

    public Route(Long routeID, String name, List<Stop> stops) {
        this.routeID = routeID;
        this.name = name;
        this.stops = stops;
    }

    public Long getRouteID() {
        return routeID;
    }

    public String getName() {
        return name;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
