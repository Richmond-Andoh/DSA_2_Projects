import java.io.*;
import java.util.*;

public class FileManager {

    // Save vehicles to vehicles.txt
    public static void saveVehicles(Collection<Vehicle> vehicles) {
        try (PrintWriter writer = new PrintWriter("vehicles.txt")) {
            for (Vehicle v : vehicles) {
                writer.println(v.registrationNumber + ";" + v.type + ";" +
                        v.mileage + ";" + v.fuelUsage + ";" + v.driverId);
            }
        } catch (IOException e) {
            System.out.println("Error saving vehicles: " + e.getMessage());
        }
    }

    // Load vehicles from vehicles.txt
    public static List<Vehicle> loadVehicles() {
        List<Vehicle> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String reg = parts[0];
                    String type = parts[1];
                    int mileage = Integer.parseInt(parts[2]);
                    double fuel = Double.parseDouble(parts[3]);
                    String driver = parts[4];

                    Vehicle v = new Vehicle(reg, type, mileage, fuel, driver);
                    list.add(v);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading vehicles: " + e.getMessage());
        }
        return list;
    }

    // Save deliveries to deliveries.txt
    public static void saveDeliveries(Iterable<Delivery> deliveries) {
        try (PrintWriter writer = new PrintWriter("deliveries.txt")) {
            for (Delivery d : deliveries) {
                writer.println(d.packageId + "," + d.origin + "," + d.destination + "," + d.vehicleId + "," + d.driverId + "," + d.eta + "," + d.status);
            }
        } catch (IOException e) {
            System.out.println("Error saving deliveries: " + e.getMessage());
        }
    }

    // Load deliveries from deliveries.txt
    public static java.util.List<Delivery> loadDeliveries() {
        java.util.List<Delivery> list = new java.util.ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("deliveries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Delivery d = new Delivery(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], "in transit");
                    list.add(d);
                } else if (parts.length == 7) {
                    Delivery d = new Delivery(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    list.add(d);
                }
            }
        } catch (IOException e) {
            // File may not exist on first run
        }
        return list;
    }

    // Save drivers to drivers.txt
    public static void saveDrivers(Iterable<Driver> drivers) {
        try (PrintWriter writer = new PrintWriter("drivers.txt")) {
            for (Driver d : drivers) {
                writer.println(d.id + "," + d.name + "," + d.experience + "," + d.infractions + "," + d.lastRoute);
            }
        } catch (IOException e) {
            System.out.println("Error saving drivers: " + e.getMessage());
        }
    }

    // Load drivers from drivers.txt
    public static java.util.List<Driver> loadDrivers() {
        java.util.List<Driver> list = new java.util.ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Driver d = new Driver(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                    list.add(d);
                }
            }
        } catch (IOException e) {
            // File may not exist on first run
        }
        return list;
    }

    // Save maintenance records to maintenance.txt
    public static void saveMaintenance(Iterable<MaintenanceRecord> records) {
        try (PrintWriter writer = new PrintWriter("maintenance.txt")) {
            for (MaintenanceRecord r : records) {
                writer.print(r.vehicleId + "," + r.mileageSinceLastService + "," + r.lastServiceDate + ",");
                if (r.partsReplaced != null) {
                    for (int i = 0; i < r.partsReplaced.length; i++) {
                        writer.print(r.partsReplaced[i]);
                        if (i < r.partsReplaced.length - 1) writer.print("|");
                    }
                }
                writer.println("," + r.cost);
            }
        } catch (IOException e) {
            System.out.println("Error saving maintenance: " + e.getMessage());
        }
    }

    // Load maintenance records from maintenance.txt
    public static java.util.List<MaintenanceRecord> loadMaintenance() {
        java.util.List<MaintenanceRecord> list = new java.util.ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("maintenance.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String[] replaced = parts[3].isEmpty() ? new String[0] : parts[3].split("\\|");
                    MaintenanceRecord r = new MaintenanceRecord(parts[0], Integer.parseInt(parts[1]), parts[2], replaced, Double.parseDouble(parts[4]));
                    list.add(r);
                }
            }
        } catch (IOException e) {
            // File may not exist on first run
        }
        return list;
    }
}
