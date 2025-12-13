package entity;

public class Booking {
    private long bookingId;
    private final long passengerId;
    private final long tripId;


    public Booking(long passengerId, long tripId) {
        this.passengerId = passengerId;
        this.tripId = tripId;
    }


    public long getBookingId() {
        return bookingId;
    }


    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }


    public long getPassengerId() {
        return passengerId;
    }


    public long getTripId() {
        return tripId;
    }
}
