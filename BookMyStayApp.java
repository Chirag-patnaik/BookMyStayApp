/**
 * Book My Stay App
 * Hotel Booking Management System
 *
 * This application is developed incrementally
 * through Use Case 1 to Use Case 12.
 *
 * Current Implementation:
 * Use Case 10 - Booking Cancellation & Inventory Rollback
 *
 * @author Chirag Patnaik
 * @version 1.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       BOOK MY STAY APP");
        System.out.println("==================================");

        // Create Room Objects
        Room single = new SingleRoom();
        Room doubleroom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Store Rooms
        Room[] rooms = { single, doubleroom, suite };

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Services
        RoomSearchService searchService = new RoomSearchService();
        BookingQueue bookingQueue = new BookingQueue();
        BookingHistory bookingHistory = new BookingHistory();
        BookingService bookingService = new BookingService();
        BookingReportService reportService = new BookingReportService();
        AddOnServiceManager serviceManager = new AddOnServiceManager();
        CancellationService cancellationService = new CancellationService();

        // Display Rooms
        searchService.searchAvailableRooms(rooms, inventory);

        System.out.println();

        // Booking Requests
        bookingQueue.addBookingRequest(
                new Reservation("Ramsha", "Single Room"));

        bookingQueue.addBookingRequest(
                new Reservation("Adtiya", "Double Room"));

        bookingQueue.addBookingRequest(
                new Reservation("Sneha", "Suite Room"));

        System.out.println();

        bookingQueue.displayBookingRequests();

        System.out.println();

        // Process Bookings
        bookingService.processBookings(
                bookingQueue.getBookingQueue(),
                inventory,
                bookingHistory);

        System.out.println();

        // Inventory After Booking
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

        // Booking History
        reportService.displayReport(bookingHistory);

        // Cancel Reservation RES2
        Reservation reservation =
                bookingHistory.getReservation("RES2");

        if (reservation != null) {

            cancellationService.cancelReservation(
                    reservation,
                    inventory);
        }

        System.out.println();

        // Updated Inventory After Cancellation
        inventory.displayInventory();

        // Released Room IDs
        cancellationService.displayReleasedRooms();
    }
}