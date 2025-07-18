import java.util.List;
import java.util.Scanner;

public class DriverManager {
    DriverQueue driverQueue = new DriverQueue();
    Scanner scanner = new Scanner(System.in);

    // Add a new driver to the queue
    public void addDriver() {
        System.out.print("Enter driver ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter years of experience: ");
        int exp = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of infractions: ");
        int infractions = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter last route (or 'None'): ");
        String route = scanner.nextLine();

        Driver driver = new Driver(id, name, exp, infractions, route);
        driverQueue.enqueue(driver);
        saveDriversToFile();
        System.out.println("✅ Driver added to the queue.");
    }

    // Assign the next available driver
    public void assignDriver() {
        Driver driver = driverQueue.dequeue();
        if (driver != null) {
            System.out.println("✅ Driver Assigned:");
            System.out.println(driver);
            saveDriversToFile();
        }
    }

    // Show all available drivers
    public void viewDrivers() {
        driverQueue.displayDrivers();
    }

    // Load drivers from file
    public void loadDriversFromFile() {
        List<Driver> loaded = FileManager.loadDrivers();
        for (Driver d : loaded) {
            driverQueue.enqueue(d);
        }
    }

    // Save drivers to file
    public void saveDriversToFile() {
        java.util.List<Driver> drivers = new java.util.ArrayList<>();
        // Collect all drivers in the queue
        // (Assume front to rear, non-destructive)
        try {
            java.lang.reflect.Field frontField = driverQueue.getClass().getDeclaredField("front");
            java.lang.reflect.Field rearField = driverQueue.getClass().getDeclaredField("rear");
            java.lang.reflect.Field queueField = driverQueue.getClass().getDeclaredField("queue");
            frontField.setAccessible(true);
            rearField.setAccessible(true);
            queueField.setAccessible(true);
            int front = frontField.getInt(driverQueue);
            int rear = rearField.getInt(driverQueue);
            Driver[] queue = (Driver[]) queueField.get(driverQueue);
            if (front != -1 && rear != -1) {
                for (int i = front; i <= rear; i++) {
                    drivers.add(queue[i]);
                }
            }
        } catch (Exception e) {
            // fallback: do nothing
        }
        FileManager.saveDrivers(drivers);
    }
}
