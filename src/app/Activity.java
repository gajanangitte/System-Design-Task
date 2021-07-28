package app;

import java.util.Vector;

/**
* The Activity class contains all the details of
* activity to be conducted at a specific location. 
* Class contains methods which can manipulate & modify
* travel activities and passengers of the traveler.
* 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/
public class Activity{
    /**
     * Variables
     * {@code String name} is the name of the activity.
     * {@code Destination destination} is the description of the destination.
     * {@code Vector<Passenger> passengers} passengers available for the activity
     * {@code int price} the price of the activity
     * {@code int capacity} the capacity of the activity
     * {@code int currentTourists} the number of current tourists for the activity
     * {@code String description} the description of the activity
     * 
    */
    private String name;
    private Destination destination;
    private Vector<Passenger> passengers;
    private int price;
    private int capacity;
    private int currentTourists;
    private String description;

    /** 
     * Constructor for the Activity class
     * @param String name the name of the activity to be created
     * @param String description the description of the activity to be created
     * @param int price the cost of the activity to be created
     * @param int capacity the capacity of the activity to be created
     * @param int currentTourists the number of passengers enlisted
     * @return null
     */ 
    public Activity(String name, String description, Destination destination, int price, int capacity){
        this.name = name;
        this.description = description;
        this.destination = destination;
        this.price = price;
        this.capacity = capacity;
        this.currentTourists = 0;
        this.passengers = new Vector<Passenger>();
    }

    /** 
     * Constructor for the Activity class
     * @param String name the name of the activity to be created
     * @param String description the description of the activity to be created
     * @param int price the cost of the activity to be created
     * @param int capacity the capacity of the activity to be created
     * @param int currentTourists the number of passengers enlisted
     * @return null
     */
    public Activity(String name, String description,  Destination destination, int price, int capacity, int currentTourists){
        this.name = name;
        this.description = description;
        this.destination = destination;
        this.price = price;
        this.capacity = capacity;
        this.currentTourists = currentTourists;
        this.passengers = new Vector<Passenger>();
    }

    /** 
     * Constructor for the Activity class
     * @param String name the name of the activity to be created
     * @param String description the description of the activity to be created
     * @param int price the cost of the activity to be created
     * @param int capacity the capacity of the activity to be created
     * @param int currentTourists the number of passengers enlisted
     * @param Vector<Passenger> passengers the passengers that will attend the activity
     * @return null
     */
    public Activity(String name, String description, Destination destination, int price, int capacity, int currentTourists, Vector<Passenger> passengers){
        this.name = name;
        this.description = description;
        this.destination = destination;
        this.price = price;
        this.capacity = capacity;
        this.currentTourists = currentTourists;
        this.passengers = passengers;
    }

    
    /** 
     * Method to get the name of the activity
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * Method to get the destination of the activity
     * @return Destination
     */
    public Destination getDestination() {
        return this.destination;
    }

    
    /** 
     * Method  to get the description of the activity
     * @return String
     */
    public String getDescription() {
        return this.description;
    }    

    
    /** 
     * Method to get the price of the activity
     * @return int
     */
    public int getPrice() {
        return this.price;
    }

    
    /** 
     * Method to get the capacity of the activity
     * @return int
     */
    public int getCapacity() {
        return this.capacity;
    }

    
    /** 
     * Method to get the passengers of the activity
     * @return int
     */
    public int getTourists() {
        return this.currentTourists;
    }

    
    /** 
     * Method to add a passenger to the activity
     * @param passenger
     * @return null
     */
    public void addMember(Passenger passenger) {
        this.currentTourists++;
        this.passengers.add(passenger);
    }

    
    /** 
     * Method to set a destination for the activity
     * @param passenger
     * @return null
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /** 
     * Method to check a passenger for the activity
     * @param passenger
     * @return null
     */
    public boolean isPassenger(Passenger passenger) {
        return this.passengers.contains(passenger);
    }

    
    /** 
     * Method to stringify the activity
     * @return String
     */
    @Override
    public String toString() {
        String display = ( "Activity Name: " + this.name + "\n" + 
                         "Activity Description:" + this.description + "\n" + 
                         "Activity Cost: " + this.price + "\n" +
                         "Activity Capacity: " + this.currentTourists + "/" + this.capacity +"\n");
        return display;
    }

    
    /** 
     * Method to return activity info if given passenger is enlisted in the current activity
     * @param passenger
     * @return String
     */
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
