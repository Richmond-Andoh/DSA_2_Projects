import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DriverManager manage_driver = new DriverManager();
        DeliveryManager manage_delivery = new DeliveryManager();
        MaintenanceManager manage_maintenance = new MaintenanceManager();
        ReportManager reportManager = new ReportManager();
        VehicleManager manage_vehicle = new VehicleManager(reportManager);

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
            System.out.println("12. Schedule Vehicle Maintenance");
            System.out.println("13. View Maintenance Queue");
            System.out.println("14. Perform Next Maintenance");
            System.out.println("15. View Fuel Efficiency Report");
            System.out.println("16. Filter Vehicles by Type");
            System.out.println("17. Sort Vehicles by Mileage (Insertion)");
            System.out.println("18. Sort Vehicles by Driver Name (Merge)");
            System.out.println("19. Sort Vehicles by Fuel Usage (Quick)");

            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manage_vehicle.addVehicle();
                    break;
                case 2:
                    manage_vehicle.searchVehicle();
                    break;
                case 3:
                    manage_vehicle.removeVehicle();
                    break;
                case 4:
                    manage_vehicle.showAllVehicles();
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
                case 12:
                    manage_maintenance.scheduleMaintenance();
                    break;
                case 13:
                    manage_maintenance.viewScheduled();
                    break;
                case 14:
                    manage_maintenance.performMaintenance();
                    break;
                case 15:
                    reportManager.viewFuelReport();
                    break;
                case 16:
                    reportManager.filterByType();
                    break;
                case 17:
                    reportManager.insertionSortByMileage();
                    break;
                case 18:
                    reportManager.mergeSortByDriverName();
                    break;
                case 19:
                    reportManager.quickSortByFuelUsage();
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
