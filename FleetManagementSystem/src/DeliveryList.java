public class DeliveryList {
    private DeliveryNode head = null;

    // Add delivery to end of the list
    public void addDelivery(Delivery delivery) {
        DeliveryNode newNode = new DeliveryNode(delivery);
        if (head == null) {
            head = newNode;
        } else {
            DeliveryNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("✅ Delivery added.");
    }

    // Display all deliveries
    public void viewDeliveries() {
        if (head == null) {
            System.out.println("🚫 No deliveries found.");
            return;
        }
        DeliveryNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Update delivery status
    public void updateStatus(String packageId, String newStatus) {
        DeliveryNode current = head;
        while (current != null) {
            if (current.data.packageId.equals(packageId)) {
                current.data.status = newStatus;
                System.out.println("✅ Status updated for " + packageId);
                return;
            }
            current = current.next;
        }
        System.out.println("❌ Package not found.");
    }

    // Reroute a delivery
    public void reroute(String packageId, String newDestination) {
        DeliveryNode current = head;
        while (current != null) {
            if (current.data.packageId.equals(packageId)) {
                current.data.destination = newDestination;
                System.out.println("🔁 Delivery rerouted to " + newDestination);
                return;
            }
            current = current.next;
        }
        System.out.println("❌ Package not found.");
    }

    // Return all deliveries as an Iterable
    public Iterable<Delivery> getAllDeliveries() {
        java.util.List<Delivery> list = new java.util.ArrayList<>();
        DeliveryNode current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }
}
