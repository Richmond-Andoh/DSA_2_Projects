import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        DriverManager manage_driver = new DriverManager();
        DeliveryManager manage_delivery = new DeliveryManager();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== VEHICLE DATABASE MENU =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Show All Vehicles");
            System.out.println("5. Add Driver");
            System.out.println("6. Assign Driver");
            System.out.println("7. View Available Drivers");
            System.out.println("8. Create Delivery");
            System.out.println("9. View Deliveries");
            System.out.println("10. Update Delivery Status");
            System.out.println("11. Reroute Delivery");

            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.addVehicle();
                    break;
                case 2:
                    manager.searchVehicle();
                    break;
                case 3:
                    manager.removeVehicle();
                    break;
                case 4:
                    manager.showAllVehicles();
                    break;
                case 5:
                    manage_driver.addDriver();
                    break;
                case 6:
                    manage_driver.assignDriver();
                    break;
                case 7:
                    manage_driver.viewDrivers();
                    break;
                case 8:
                    manage_delivery.createDelivery();
                    break;
                case 9:
                    manage_delivery.viewAll();
                    break;
                case 10:
                    manage_delivery.updateStatus();
                    break;
                case 11:
                    manage_delivery.rerouteDelivery();
                    break;
                case 0:
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }

        } while (choice != 0);
    }
}
