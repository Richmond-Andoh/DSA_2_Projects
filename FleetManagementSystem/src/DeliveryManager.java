import java.util.List;
import java.util.Scanner;

public class DeliveryManager {
    DeliveryList deliveryList = new DeliveryList();
    Scanner scanner = new Scanner(System.in);

    // Load deliveries from file using FileManager
    public void loadDeliveriesFromFile() {
        List<Delivery> loaded = FileManager.loadDeliveries();
        for (Delivery d : loaded) {
            deliveryList.addDelivery(d);
        }
    }

    // Save deliveries to file using FileManager
    public void saveDeliveriesToFile() {
        FileManager.saveDeliveries(deliveryList.getAllDeliveries());
    }

    // Add a new delivery
    public void createDelivery() {
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine();

        System.out.print("Origin: ");
        String origin = scanner.nextLine();

        System.out.print("Destination: ");
        String dest = scanner.nextLine();

        System.out.print("Vehicle ID: ");
        String vid = scanner.nextLine();

        System.out.print("Driver ID: ");
        String did = scanner.nextLine();

        System.out.print("ETA (e.g., 14:00): ");
        String eta = scanner.nextLine();

        String status = "in transit";

        Delivery delivery = new Delivery(id, origin, dest, vid, did, eta, status);
        deliveryList.addDelivery(delivery);
        saveDeliveriesToFile();
    }

    // View all deliveries
    public void viewAll() {
        deliveryList.viewDeliveries();
    }

    // Update status
    public void updateStatus() {
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter new status: ");
        String status = scanner.nextLine();

        deliveryList.updateStatus(id, status);
        saveDeliveriesToFile();
    }

    // Reroute a delivery
    public void rerouteDelivery() {
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter new destination: ");
        String newDest = scanner.nextLine();

        deliveryList.reroute(id, newDest);
        saveDeliveriesToFile();
    }
}
