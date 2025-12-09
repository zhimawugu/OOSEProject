package service;

import entity.Route;
import entity.Stop;
import exception.RouteNameEmptyException;
import exception.StopsInfoEmptyException;

import java.util.List;

public class RouteService {

    private StopService stopService;

    public RouteService(StopService stopService) {
        this.stopService = stopService;
    }

    public Route createRoute(String routeName, String[] stopsInfo) {

        validateRouteName(routeName);
        validateStopsInfo(stopsInfo);

        List<Stop> stops = stopService.createStops(stopsInfo);
        Route route = new Route(System.currentTimeMillis(), routeName, stops);
        return route;
    }

    private void validateRouteName(String routeName) {
        if (routeName == null || routeName.length() == 0) {
            throw new RouteNameEmptyException();
        }
    }

    private void validateStopsInfo(String[] stopsInfo) {
        if (stopsInfo == null || stopsInfo.length == 0) {
            throw new StopsInfoEmptyException();
        }
    }
}

