package entity;

import service.RouteService;

public class Admin {
    private Long adminID;
    private String name;

    public Admin(Long adminID, String name) {
        this.adminID = adminID;
        this.name = name;
    }

    public Route createRoute(String routeName, String[] stopsInfo, RouteService routeService) {
        return routeService.createRoute(routeName, stopsInfo);
    }

    public Trip createTrip(Long tripId, Route route) {
        return new Trip(tripId, java.time.LocalDateTime.now(), route);
    }
}
