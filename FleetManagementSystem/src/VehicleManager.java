import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class VehicleManager {
    HashMap<String, Vehicle> vehicleMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    ReportManager reportManager;


    // Constructor Function
    public VehicleManager(ReportManager reportManager) {
        this.reportManager = reportManager;
        List<Vehicle> loaded = FileManager.loadVehicles();
        for (Vehicle v : loaded) {
            vehicleMap.put(v.registrationNumber, v);
            reportManager.addVehicleForReport(v);
        }
    }

    // Save vehicles to file
    public void saveVehiclesToFile() {
        FileManager.saveVehicles(vehicleMap.values());
    }

    // Load vehicles from file
    public void loadVehiclesFromFile() {
        vehicleMap.clear();
        List<Vehicle> loaded = FileManager.loadVehicles();
        for (Vehicle v : loaded) {
            vehicleMap.put(v.registrationNumber, v);
            reportManager.addVehicleForReport(v);
        }
    }

    // Add a vehicle
    public void addVehicle() {
        System.out.print("Enter registration number: ");
        String reg = scanner.nextLine();

        System.out.print("Enter type (van/truck): ");
        String type = scanner.nextLine();

        System.out.print("Enter mileage (in km): ");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter fuel usage (litres/km): ");
        double fuelUsage = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter driver ID: ");
        String driverId = scanner.nextLine();

        Vehicle vehicle = new Vehicle(reg, type, mileage, fuelUsage, driverId);
        vehicleMap.put(reg, vehicle);
        saveVehiclesToFile();
        System.out.println("Vehicle added!");
    }

    // Search for a vehicle
    public void searchVehicle() {
        System.out.print("Enter registration number to search: ");
        String reg = scanner.nextLine();

        if (vehicleMap.containsKey(reg)) {
            System.out.println("✅ Vehicle found:");
            System.out.println(vehicleMap.get(reg));
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Remove a vehicle
    public void removeVehicle() {
        System.out.print("Enter registration number to remove: ");
        String reg = scanner.nextLine();

        if (vehicleMap.remove(reg) != null) {
            saveVehiclesToFile();
            System.out.println("Vehicle removed.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Show all vehicles
    public void showAllVehicles() {
        System.out.println("All Vehicles:");
        for (Vehicle v : vehicleMap.values()) {
            System.out.println(v);
        }
    }
}
