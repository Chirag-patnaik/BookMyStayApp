/**
 * Book My Stay App
 * Hotel Booking Management System
 *
 * This application is developed incrementally
 * through Use Case 1 to Use Case 12.
 *
 * Current Implementation:
 * Use Case 7 - Add-On Service Selection
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
        Room[] rooms = {single, doubleroom, suite};

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Search Service
        RoomSearchService searchService = new RoomSearchService();

        // Booking Queue
        BookingQueue bookingQueue = new BookingQueue();

        // Booking Service
        BookingService bookingService = new BookingService();

        // Add-On Service Manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

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

        System.out.println();

        // Display Booking Queue
        bookingQueue.displayBookingRequests();

        System.out.println();

        // Process Bookings
        bookingService.processBookings(
                bookingQueue.getBookingQueue(),
                inventory);

        System.out.println();

        // Display Updated Inventory
        inventory.displayInventory();

        // Add-On Services
        serviceManager.addService(
                "SI1",
                new AddOnService("Breakfast", 500));

        serviceManager.addService(
                "SI1",
                new AddOnService("Airport Pickup", 1200));

        serviceManager.addService(
                "DO2",
                new AddOnService("Spa", 2000));

        System.out.println();

        // Display Add-On Services
        serviceManager.displayServices();
    }
}