import java.util.Scanner;

public class DeliveryManager {
    DeliveryList deliveryList = new DeliveryList();
    Scanner scanner = new Scanner(System.in);

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
    }

    // Reroute a delivery
    public void rerouteDelivery() {
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter new destination: ");
        String newDest = scanner.nextLine();

        deliveryList.reroute(id, newDest);
    }
}
