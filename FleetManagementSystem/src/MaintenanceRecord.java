public class MaintenanceRecord {
    String vehicleId;
    int mileageSinceLastService;
    String lastServiceDate;
    String[] partsReplaced;
    double cost;

    public MaintenanceRecord(String vehicleId, int mileage, String date, String[] partsReplaced, double cost) {
        this.vehicleId = vehicleId;
        this.mileageSinceLastService = mileage;
        this.lastServiceDate = date;
        this.partsReplaced = partsReplaced;
        this.cost = cost;
    }

    public String toString() {
        StringBuilder parts = new StringBuilder();
        for (String p : partsReplaced) {
            parts.append(p).append(", ");
        }
        return vehicleId + " | Mileage: " + mileageSinceLastService +
                "km | Last Serviced: " + lastServiceDate +
                " | Parts: " + parts + "| Cost: GH¢" + cost;
    }
}
