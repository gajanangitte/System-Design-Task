package app;

import java.util.Vector;

public class Activity{

    private String name;
    private Destination destination;
    private Vector<Passenger> passengers;
    private int price;
    private int capacity;
    private int currentTourists;
    private String description;

    Activity(String name, Destination destination, int price, int capacity){
        this.name = name;
        this.destination = destination;
        this.price = price;
        this.capacity = capacity;
        this.currentTourists = 0;
    }

    Activity(String name, Destination destination, int price, int capacity, int currentTourists){
        this.name = name;
        this.destination = destination;
        this.price = price;
        this.capacity = capacity;
        this.currentTourists = currentTourists;
    }

    public String getName() {
        return this.name;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public String getDescription() {
        return this.description;
    }    

    public int getPrice() {
        return this.price;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getTourists() {
        return this.currentTourists;
    }

    public void addMember(Passenger passenger) {
        this.currentTourists++;
        this.passengers.add(passenger);
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        String display = ( "Activity Name: " + this.name + "\n" + 
                         "Activity Description:" + this.description + "\n" + 
                         "Activity Cost: " + this.price + "\n" +
                         "Activity Capacity: " + this.currentTourists + "/" + this.capacity +"\n");
        return display;
    }

    public String toString(Passenger passenger) {
        if(this.passengers.contains(passenger)) {
            String display = ( "Activity Name: " + this.name + "\n" + 
                            "Activity Description:" + this.description + "\n" + 
                            "Activity Cost: " + this.price + "\n" +
                            "Activity Capacity: " + this.currentTourists + "/" + this.capacity +"\n");
            return display;
        } else {
            return null;
        }
    }
}
