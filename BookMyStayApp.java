/**
 * Book My Stay App
 * Hotel Booking Management System
 *
 * This application is developed incrementally
 * through Use Case 1 to Use Case 12.
 *
 * Current Implementation:
 * Use Case 5 - Booking Request (First-Come-First-Served)
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

        // Store all rooms in an array
        Room[] rooms = {single, doubleroom, suite};

        // Create Inventory
        RoomInventory inventory = new RoomInventory();

        // Create Search Service
        RoomSearchService searchService = new RoomSearchService();

        BookingQueue bookingQueue = new BookingQueue();
        

        // Search Available Rooms
        searchService.searchAvailableRooms(rooms, inventory);
        System.out.println();

bookingQueue.addBookingRequest(
        new Reservation("Ramsha", "Single Room"));

bookingQueue.addBookingRequest(
        new Reservation("Adtiya", "Double Room"));

bookingQueue.addBookingRequest(
        new Reservation("Sneha", "Suite Room"));

bookingQueue.displayBookingRequests();
    }
}