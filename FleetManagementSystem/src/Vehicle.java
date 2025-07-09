public class Vehicle {
    String registrationNumber;
    String type;  // truck or van
    int mileage;
    double fuelUsage;
    String driverId;

    public Vehicle(String registrationNumber, String type, int mileage, double fuelUsage, String driverId) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.mileage = mileage;
        this.fuelUsage = fuelUsage;
        this.driverId = driverId;
    }

    public String toString() {
        return registrationNumber + " | " + type + " | " + mileage + "km | " + fuelUsage + "L/km | Driver: " + driverId;
    }
}

