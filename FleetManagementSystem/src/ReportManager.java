import java.util.Scanner;

public class ReportManager {
    Scanner scanner = new Scanner(System.in);

    // Hardcoded for now — in real case, you'd read from a file or list
    Vehicle[] vehicleArray = new Vehicle[100];
    int count = 0;

    public void addVehicleForReport(Vehicle v) {
        vehicleArray[count++] = v;
    }

    public void viewFuelReport() {
        System.out.println("🚗 Fuel Efficiency Report:");
        for (int i = 0; i < count; i++) {
            double fuelRate = vehicleArray[i].fuelUsage;
            System.out.print(vehicleArray[i]);

            if (fuelRate > 1.5) {
                System.out.println(" ⚠️ High fuel usage!");
            } else {
                System.out.println(" ✅ Normal");
            }
        }
    }

    public void filterByType() {
        System.out.print("Enter type to filter (van/truck): ");
        String type = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (vehicleArray[i].type.equalsIgnoreCase(type)) {
                System.out.println(vehicleArray[i]);
            }
        }
    }

    public void insertionSortByMileage() {
        for (int i = 1; i < count; i++) {
            Vehicle key = vehicleArray[i];
            int j = i - 1;

            while (j >= 0 && vehicleArray[j].mileage > key.mileage) {
                vehicleArray[j + 1] = vehicleArray[j];
                j--;
            }
            vehicleArray[j + 1] = key;
        }

        System.out.println("📊 Vehicles sorted by mileage (Insertion Sort):");
        for (int i = 0; i < count; i++) {
            System.out.println(vehicleArray[i]);
        }
    }


        public void mergeSortByDriverName() {
        mergeSort(vehicleArray, 0, count - 1);
        System.out.println("📊 Vehicles sorted by driver name (Merge Sort):");
        for (int i = 0; i < count; i++) {
            System.out.println(vehicleArray[i]);
        }
    }

    private void mergeSort(Vehicle[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(Vehicle[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Vehicle[] L = new Vehicle[n1];
        Vehicle[] R = new Vehicle[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].driverId.compareTo(R[j].driverId) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    
        public void quickSortByFuelUsage() {
        quickSort(vehicleArray, 0, count - 1);
        System.out.println("📊 Vehicles sorted by fuel usage (Quick Sort):");
        for (int i = 0; i < count; i++) {
            System.out.println(vehicleArray[i]);
        }
    }

    private void quickSort(Vehicle[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Vehicle[] arr, int low, int high) {
        double pivot = arr[high].fuelUsage;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].fuelUsage < pivot) {
                i++;
                Vehicle temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Vehicle temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
// This class manages vehicle reports, including fuel efficiency, filtering by type,