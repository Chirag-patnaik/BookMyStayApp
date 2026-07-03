import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> bookingHistory;

    public BookingHistory() {

        bookingHistory = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {

        bookingHistory.add(reservation);
    }

    public List<Reservation> getBookingHistory() {

        return bookingHistory;
    }
}