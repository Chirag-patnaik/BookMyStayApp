/**
 * Book My Stay App
 * Hotel Booking Management System
 *
 * Current Implementation:
 * Use Case 12 - Data Persistence & System Recovery
 *
 * @author Chirag Patnaik
 * @version 1.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       BOOK MY STAY APP");
        System.out.println("==================================");

        Room single = new SingleRoom();
        Room doubleroom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Room[] rooms = {single, doubleroom, suite};

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();
        BookingQueue bookingQueue = new BookingQueue();
        BookingHistory bookingHistory = new BookingHistory();
        BookingService bookingService = new BookingService();
        BookingReportService reportService = new BookingReportService();
        AddOnServiceManager serviceManager = new AddOnServiceManager();
        CancellationService cancellationService = new CancellationService();
        PersistenceService persistenceService = new PersistenceService();

        // Display Available Rooms
        searchService.searchAvailableRooms(rooms, inventory);

        System.out.println();

        // Booking Requests
        bookingQueue.addBookingRequest(
                new Reservation("Ramsha", "Single Room"));

        bookingQueue.addBookingRequest(
                new Reservation("Adtiya", "Double Room"));

        bookingQueue.addBookingRequest(
                new Reservation("Sneha", "Suite Room"));

        bookingQueue.displayBookingRequests();

        System.out.println();

        // Concurrent Booking
        ConcurrentBookingProcessor thread1 =
                new ConcurrentBookingProcessor(
                        bookingQueue,
                        bookingService,
                        inventory,
                        bookingHistory);

        ConcurrentBookingProcessor thread2 =
                new ConcurrentBookingProcessor(
                        bookingQueue,
                        bookingService,
                        inventory,
                        bookingHistory);

        thread1.setName("Guest-Thread-1");
        thread2.setName("Guest-Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        inventory.displayInventory();

        // Add-On Services
        serviceManager.addService(
                "RES1",
                new AddOnService("Breakfast", 500));

        serviceManager.addService(
                "RES1",
                new AddOnService("Airport Pickup", 1200));

        serviceManager.addService(
                "RES2",
                new AddOnService("Spa", 2000));

        System.out.println();

        serviceManager.displayServices();

        // Booking Report
        reportService.displayReport(bookingHistory);

        // Cancel Reservation
        Reservation reservation =
                bookingHistory.getReservation("RES2");

        if (reservation != null) {

            cancellationService.cancelReservation(
                    reservation,
                    inventory);
        }

        System.out.println();

        inventory.displayInventory();

        cancellationService.displayReleasedRooms();

        // Save Data
        persistenceService.saveBookings(bookingHistory);

        // Recover Data
        persistenceService.loadBookings();
    }
}