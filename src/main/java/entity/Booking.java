package entity;

public class Booking {
    private Long bookingID;
    private Long passengerID;
    private Trip trip;

    public Booking(Long bookingID, Long passengerID, Trip trip) {
        this.bookingID = bookingID;
        this.passengerID = passengerID;
        this.trip = trip;
    }

    public Long getBookingID() {
        return bookingID;
    }

    public Long getPassengerID() {
        return passengerID;
    }

    public Trip getTrip() {
        return trip;
    }
}
