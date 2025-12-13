package service;

import entity.Trip;
import repository.TripRepository;

public class TripService {
    private final TripRepository tripRepository;


    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // 1.2.1 findTripById(tripId)
    public Trip findTripById(long tripId) {
        return tripRepository.findById(tripId); // 1.2.2 Trip | null
    }
}