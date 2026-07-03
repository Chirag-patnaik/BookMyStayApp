import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BookingService {

    private HashMap<String, Set<String>> allocatedRooms;
    private int roomCounter;
    private int reservationCounter;

    public BookingService() {

        allocatedRooms = new HashMap<>();
        roomCounter = 1;
        reservationCounter = 1;
    }

    public void processBookings(
            Queue<Reservation> bookingQueue,
            RoomInventory inventory,
            BookingHistory history) {

        while (!bookingQueue.isEmpty()) {

            Reservation reservation = bookingQueue.poll();

            String roomType = reservation.getRoomType();

            if (inventory.getAvailability(roomType) > 0) {

                String roomId =
                        roomType.substring(0, 2).toUpperCase()
                                + roomCounter++;

                String reservationId =
                        "RES" + reservationCounter++;

                allocatedRooms
                        .computeIfAbsent(roomType,
                                k -> new HashSet<>())
                        .add(roomId);

                inventory.decreaseAvailability(roomType);

                reservation.setReservationId(reservationId);
                reservation.setRoomId(roomId);
                reservation.setStatus("Confirmed");

                history.addReservation(reservation);

                System.out.println("\n========== BOOKING CONFIRMED ==========");
                System.out.println(reservation);

            } else {

                reservation.setStatus("Failed");

                System.out.println("\nBooking Failed!");
                System.out.println("No rooms available for "
                        + roomType);
            }
        }
    }
}