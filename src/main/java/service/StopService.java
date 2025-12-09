package service;

import entity.Stop;

import java.util.ArrayList;
import java.util.List;

public class StopService {

    public List<Stop> createStops(String[] stopsInfo) {
        List<Stop> stops = new ArrayList<>();
        long id = 1;

        for (String stopName : stopsInfo) {
            stops.add(new Stop(id++, stopName));
        }
        return stops;
    }
}
