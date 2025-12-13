package repository;

import entity.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private final Map<Long, Booking> storage = new HashMap<>();
    private long idSeq = 1;


    public boolean exists(long passengerId, long tripId) {
        return storage.values().stream()
                .anyMatch(b -> b.getPassengerId() == passengerId && b.getTripId() == tripId);
    }

    public void save(Booking booking) {
        booking.setBookingId(idSeq++);
        storage.put(booking.getBookingId(), booking);
    }
}
