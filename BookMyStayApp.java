/**
 * Use Case 2
 * Book My Stay App
 * Hotel Booking Management System
 *
 * Demonstrates room creation using
 * abstraction, inheritance and polymorphism.
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

RoomInventory inventory = new RoomInventory();

        single.displayRoomDetails();
    System.out.println("Available : " + inventory.getAvailability(single.getRoomType()));   

        System.out.println();

        doubleroom.displayRoomDetails();
System.out.println("Available : " + inventory.getAvailability(doubleroom.getRoomType()));

        System.out.println();

        suite.displayRoomDetails();
System.out.println("Available : " + inventory.getAvailability(suite.getRoomType()));

System.out.println();

inventory.displayInventory();

    }
}