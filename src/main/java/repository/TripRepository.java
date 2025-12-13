package repository;

import entity.Trip;

import java.util.HashMap;
import java.util.Map;

public class TripRepository {
    private final Map<Long, Trip> trips = new HashMap<>();
    public TripRepository() {
    }

    public void save(Trip trip) {
        trips.put(trip.getTripID(), trip);
    }

    public Trip findById(long tripId) {
        return trips.get(tripId);
    }
}
