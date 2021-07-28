package app;
import java.util.Vector;

public class TravelPackage {
    private String packageName;
    private String description;
    private int passengerCapacity;
    private int packageCost;
    private Vector<Destination> destinations;
    private Vector<Passenger> passengers;

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

    public String getpackageName() {
        return this.packageName;
    }
    
    public String description() {
        return this.description;
    }
    
    public int packageCost() {
        return this.packageCost;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public Vector<Passenger> getPassengers() {
        return this.passengers;
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

    public void showPackages() {
        System.out.println("Name: " + this.packageName);
        System.out.println("Destinations and Activities: ");
        for(Destination destination : this.destinations) {
            System.out.println(destination);
        }
        System.out.println("Passengers: ");
        for(Passenger passenger : this.passengers) {
            System.out.println(passenger);
        }
    }

    public void showPackages(Passenger passenger) {
        System.out.println("Name: " + this.packageName);
        System.out.println("Destinations and Activities: ");
        for(Destination destination : this.destinations) {
            System.out.println(destination.toString(passenger));
        }
    }

    public void addMember(Passenger passenger) {
        this.passengers.add(passenger);
    }


}
