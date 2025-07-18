import java.util.List;
import java.util.Scanner;

public class MaintenanceManager {
    MaintenanceHeap heap = new MaintenanceHeap();
    Scanner scanner = new Scanner(System.in);

    // Save maintenance records to file
    public void saveMaintenanceToFile() {
        java.util.List<MaintenanceRecord> records = new java.util.ArrayList<>();
        // Extract all records from the heap (non-destructive)
        try {
            java.lang.reflect.Field heapField = heap.getClass().getDeclaredField("heap");
            java.lang.reflect.Field sizeField = heap.getClass().getDeclaredField("size");
            heapField.setAccessible(true);
            sizeField.setAccessible(true);
            MaintenanceRecord[] arr = (MaintenanceRecord[]) heapField.get(heap);
            int size = sizeField.getInt(heap);
            for (int i = 0; i < size; i++) {
                records.add(arr[i]);
            }
        } catch (Exception e) {
            // fallback: do nothing
        }
        FileManager.saveMaintenance(records);
    }

    // Load maintenance records from file
    public void loadMaintenanceFromFile() {
        List<MaintenanceRecord> loaded = FileManager.loadMaintenance();
        for (MaintenanceRecord r : loaded) {
            heap.insert(r);
        }
    }

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
        saveMaintenanceToFile();
    }

    public void performMaintenance() {
        MaintenanceRecord next = heap.removeMin();
        if (next == null) {
            System.out.println("🚫 No maintenance scheduled.");
        } else {
            System.out.println("🛠️ Performing maintenance on:");
            System.out.println(next);
        }
        saveMaintenanceToFile();
    }

    public void viewScheduled() {
        heap.displayHeap();
    }
}

