public class MaintenanceHeap {
    private MaintenanceRecord[] heap = new MaintenanceRecord[100];
    private int size = 0;

    // Compare by mileage — smallest on top
    private boolean isHigherPriority(MaintenanceRecord a, MaintenanceRecord b) {
        return a.mileageSinceLastService < b.mileageSinceLastService;
    }

    private void swap(int i, int j) {
        MaintenanceRecord temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Add a new record
    public void insert(MaintenanceRecord record) {
        heap[size] = record;
        int i = size;
        size++;

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (isHigherPriority(heap[i], heap[parent])) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
        System.out.println("✅ Maintenance record added.");
    }

    // Remove the vehicle that needs service soonest
    public MaintenanceRecord removeMin() {
        if (size == 0) return null;

        MaintenanceRecord min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && isHigherPriority(heap[left], heap[smallest])) smallest = left;
            if (right < size && isHigherPriority(heap[right], heap[smallest])) smallest = right;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else break;
        }

        return min;
    }

    public void displayHeap() {
        if (size == 0) {
            System.out.println("🚫 No vehicles scheduled for maintenance.");
            return;
        }

        System.out.println("🛠️ Maintenance Queue:");
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }
}
