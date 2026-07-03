import java.util.*;

public class AddOnServiceManager {

    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {

        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public void displayServices() {

        System.out.println("\n========== ADD-ON SERVICES ==========\n");

        for (String reservation : reservationServices.keySet()) {

            System.out.println("Reservation : " + reservation);

            double total = 0;

            for (AddOnService service : reservationServices.get(reservation)) {

                System.out.println(service);

                total += service.getCost();
            }

            System.out.println("Total Add-on Cost : Rs. " + total);
            System.out.println();
        }
    }
}