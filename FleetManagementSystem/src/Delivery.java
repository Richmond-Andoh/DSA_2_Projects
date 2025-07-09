public class Delivery {
    String packageId;
    String origin;
    String destination;
    String vehicleId;
    String driverId;
    String eta;
    String status;

    public Delivery(String packageId, String origin, String destination,
                    String vehicleId, String driverId, String eta, String status) {
        this.packageId = packageId;
        this.origin = origin;
        this.destination = destination;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.eta = eta;
        this.status = status;
    }

    public String toString() {
        return packageId + " | From: " + origin + " To: " + destination +
               " | Vehicle: " + vehicleId + " | Driver: " + driverId +
               " | ETA: " + eta + " | Status: " + status;
    }
}
