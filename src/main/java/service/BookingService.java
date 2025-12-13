package service;

import entity.Booking;
import entity.Trip;
import repository.BookingRepository;

public class BookingService {
    private final TripService tripService;
    private final BookingRepository bookingRepository;


    public BookingService(TripService tripService, BookingRepository bookingRepository) {
        this.tripService = tripService;
        this.bookingRepository = bookingRepository;
    }


    public long bookTrip(long tripId, long passengerId) {
        // 1.2 validateTrip(tripId)
        Trip trip = tripService.findTripById(tripId);
        if (trip == null) { // 1.2.3 TripFound? false
            throw new IllegalArgumentException("Trip not found");
        }


        // 1.3 existsBooking(passengerId, tripId)?
        boolean exists = bookingRepository.exists(passengerId, tripId); // 1.3.1
        if (exists) {
            throw new IllegalStateException("Booking already exists");
        }


    // 1.4 saveBooking(passengerId, tripId)
        Booking booking = new Booking(passengerId, tripId);
        bookingRepository.save(booking);


        return booking.getBookingId(); // 1.4.1
    }
}