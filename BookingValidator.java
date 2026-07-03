public class BookingValidator {

    public void validateReservation(
            Reservation reservation,
            RoomInventory inventory)
            throws InvalidBookingException {

        String roomType = reservation.getRoomType();

        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidBookingException(
                    "Room type cannot be empty.");
        }

        if (inventory.getAvailability(roomType) <= 0) {
            throw new InvalidBookingException(
                    "No rooms available for " + roomType);
        }
    }
}