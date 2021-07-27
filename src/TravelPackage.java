import java.util.Vector;

public class TravelPackage {
    String packageName;
    String description;
    int passengerCapacity;
    int packageCost;
    Vector<Destination> destinations;
    Vector<Passenger> passengers;

    TravelPackage(String packageName, String description, int passengerCapacity, int packageCost) {
        this.packageName = packageName;
        this.description = description;
        this.packageCost = packageCost;
    }

    TravelPackage(String packageName, String description, int passengerCapacity, int packageCost, Vector<Destination> destinations) {
        this.packageName = packageName;
        this.description = description;
        this.packageCost = packageCost;
        this.destinations = destinations;
    }
    
    TravelPackage(String packageName, String description, int passengerCapacity, int packageCost, Vector<Destination> destinations, Vector<Passenger> passengers) {
        this.packageName = packageName;
        this.description = description;
        this.packageCost = packageCost;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    public void addDestination(Destination destination) {
        this.destinations.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void displayPassengers() {
        for(Passenger passenger :this.passengers) {
            System.out.println(passenger);
        }
    }
}
