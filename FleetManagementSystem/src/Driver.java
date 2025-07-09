public class Driver {
    String id;
    String name;
    int experience; // years of driving
    int infractions; // number of traffic issues
    String lastRoute;

    public Driver(String id, String name, int experience, int infractions, String lastRoute) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.infractions = infractions;
        this.lastRoute = lastRoute;
    }

    public String toString() {
        return id + " | " + name + " | " + experience + " yrs | Infractions: " + infractions + " | Last Route: " + lastRoute;
    }
}
