import controller.BookingController;
import entity.Booking;
import entity.BookingResponse;
import entity.Route;
import entity.Trip;
import org.junit.jupiter.api.*;
import repository.BookingRepository;
import repository.TripRepository;
import service.BookingService;
import service.TripService;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {

    private BookingController controller;
    private BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        TripRepository tripRepository = new TripRepository();

        // mock data
        tripRepository.save(new Trip(1L, LocalDateTime.of(2025, 1, 1, 10, 0), testRoute(10L, "Dublin -> Cork")));
        tripRepository.save(new Trip(2L, LocalDateTime.of(2025, 1, 1, 12, 0), testRoute(20L, "Dublin -> Galway")));

        bookingRepository = new BookingRepository();

        TripService tripService = new TripService(tripRepository);
        BookingService bookingService = new BookingService(tripService, bookingRepository);
        controller = new BookingController(bookingService);
    }

    private Route testRoute(Long routeId, String name) {
        return new Route(routeId, name, new ArrayList<>());
    }

    // ===== Happy Path =====
    @Test
    void bookTrip_success() {
        BookingResponse response = controller.bookTrip(1L, 1001L);

        assertNotNull(response);
        assertTrue(response.getBookingId() > 0);
    }

    // ===== Unhappy Path 1: Trip not found =====
    @Test
    void bookTrip_tripNotFound_shouldThrowException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> controller.bookTrip(999L, 1001L)
        );

        assertEquals("Trip not found", ex.getMessage());
    }

    // ===== Unhappy Path 2: Duplicate booking =====
    @Test
    void bookTrip_duplicateBooking_shouldThrowException() {
        controller.bookTrip(1L, 1001L);

        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> controller.bookTrip(1L, 1001L)
        );

        assertEquals("Booking already exists", ex.getMessage());
    }

    // ===== Repository-level test =====
    @Test
    void bookingRepository_exists_shouldReturnTrue() {
        Booking booking = new Booking(1001L, 1L);
        bookingRepository.save(booking);

        boolean exists = bookingRepository.exists(1001L, 1L);
        assertTrue(exists);
    }
}

// ===== Optional: Controller-focused test =====
class BookingControllerTest {

    @Test
    void controller_shouldReturnBookingResponse() {
        TripRepository tripRepository = new TripRepository();
        BookingRepository bookingRepository = new BookingRepository();

        TripService tripService = new TripService(tripRepository);
        BookingService bookingService = new BookingService(tripService, bookingRepository);
        BookingController controller = new BookingController(bookingService);

        BookingResponse response = controller.bookTrip(2L, 2002L);

        assertNotNull(response);
        assertTrue(response.getBookingId() > 0);
    }
}

