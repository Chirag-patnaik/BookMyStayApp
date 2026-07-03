/**
 * Book My Stay App
 * Hotel Booking Management System
 *
 * This application is developed incrementally
 * through Use Case 1 to Use Case 12.
 *
 * Current Implementation:
 * Use Case 6 - Reservation Confirmation & Room Allocation
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

        bookingQueue.displayBookingRequests();

        System.out.println();

        // Process Bookings
        bookingService.processBookings(
                bookingQueue.getBookingQueue(),
                inventory);

        System.out.println();

        // Updated Inventory
        inventory.displayInventory();
    }
}