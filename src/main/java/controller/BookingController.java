package controller;

import entity.BookingResponse;
import service.BookingService;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // 1 bookTrip(tripId, passengerId)
    public BookingResponse bookTrip(long tripId, long passengerId) {
        long bookingId = bookingService.bookTrip(tripId, passengerId); // 1.1
        return new BookingResponse(bookingId); // 1.5
    }
}
