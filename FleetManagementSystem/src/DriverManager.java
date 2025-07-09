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

        System.out.println("✅ Driver added to the queue.");
    }

    // Assign the next available driver
    public void assignDriver() {
        Driver driver = driverQueue.dequeue();
        if (driver != null) {
            System.out.println("✅ Driver Assigned:");
            System.out.println(driver);
        }
    }

    // Show all available drivers
    public void viewDrivers() {
        driverQueue.displayDrivers();
    }
}
