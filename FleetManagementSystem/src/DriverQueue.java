public class DriverQueue {
    private static final int MAX = 100;
    private Driver[] queue = new Driver[MAX];
    private int front = -1;
    private int rear = -1;

    // Add driver to queue
    public void enqueue(Driver driver) {
        if (rear == MAX - 1) {
            System.out.println("🚫 Driver queue is full!");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = driver;
    }

    // Remove and return driver from front
    public Driver dequeue() {
        if (isEmpty()) {
            System.out.println("🚫 No drivers available.");
            return null;
        }
        Driver driver = queue[front];
        front++;
        if (front > rear) {
            front = rear = -1;
        }
        return driver;
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public void displayDrivers() {
        if (isEmpty()) {
            System.out.println("🚫 No drivers in queue.");
            return;
        }
        System.out.println("🧑‍✈️ Available Drivers:");
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }
}

