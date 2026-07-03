import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BookingService {

    private HashMap<String, Set<String>> allocatedRooms;
    private int roomCounter;

    public BookingService() {

        allocatedRooms = new HashMap<>();
        roomCounter = 1;
    }

    public void processBookings(Queue<Reservation> bookingQueue,
                                RoomInventory inventory) {

        while (!bookingQueue.isEmpty()) {

            Reservation reservation = bookingQueue.poll();

            String roomType = reservation.getRoomType();

            if (inventory.getAvailability(roomType) > 0) {

                String roomId = roomType.substring(0, 2).toUpperCase() + roomCounter++;

                allocatedRooms
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.decreaseAvailability(roomType);

                System.out.println("\n========== BOOKING CONFIRMED ==========");
                System.out.println("Guest      : " + reservation.getGuestName());
                System.out.println("Room Type  : " + roomType);
                System.out.println("Room ID    : " + roomId);

            } else {

                System.out.println("\nBooking Failed!");
                System.out.println("No rooms available for " + roomType);
            }
        }
    }
}