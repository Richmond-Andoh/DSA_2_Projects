import java.util.Scanner;

public class MaintenanceManager {
    MaintenanceHeap heap = new MaintenanceHeap();
    Scanner scanner = new Scanner(System.in);

    public void scheduleMaintenance() {
        System.out.print("Enter Vehicle ID: ");
        String vid = scanner.nextLine();

        System.out.print("Enter mileage since last service: ");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter last service date (e.g., 2024-06-20): ");
        String date = scanner.nextLine();

        System.out.print("Enter parts replaced (comma-separated): ");
        String partsInput = scanner.nextLine();
        String[] parts = partsInput.split(",");

        System.out.print("Enter total cost (GHS): ");
        double cost = Double.parseDouble(scanner.nextLine());

        MaintenanceRecord record = new MaintenanceRecord(vid, mileage, date, parts, cost);
        heap.insert(record);
    }

    public void performMaintenance() {
        MaintenanceRecord next = heap.removeMin();
        if (next == null) {
            System.out.println("🚫 No maintenance scheduled.");
        } else {
            System.out.println("🛠️ Performing maintenance on:");
            System.out.println(next);
        }
    }

    public void viewScheduled() {
        heap.displayHeap();
    }
}

