package entity;

public class BookingResponse {
    private final long bookingId;


    public BookingResponse(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getBookingId() {
        return bookingId;
    }
}
