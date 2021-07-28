package app;
import java.util.Vector;

/**
* The TravelPackage file contains all the travel plans
* to be used by the Yatra system. It can manipulate and
* modify travel plans and its components.
* 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/
public class TravelPackage {
    /**
     * {@code String packageName} is the name of the package
     * {@code String description} is the description of the package
     * {@code int passengerCapacity} is the integral passenger capacity of the package
     * {@code int packageCost } is the cost of the package
     * {@code Vector<Destination> destinations} destinations available in the package
     * {@code Vector<Passenger> passengers} passengers available in the package
    */
    private String packageName;
    private String description;
    private int passengerCapacity;
    private int packageCost;
    private Vector<Destination> destinations;
    private Vector<Passenger> passengers;


    /** 
     * Constructor for the TravelPackage class
     * @param String packageName the name of the package to be create
     * @param String description the description of the package to be created
     * @param int packageCost the cost of the package to be created
     * @return null
     */
    public TravelPackage(String packageName, String description, int packageCost,  int passengerCapacity) {
        this.packageName = packageName;
        this.description = description;
        this.packageCost = packageCost;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new Vector<Destination>();
        this.passengers = new Vector<Passenger>();
    }

    /** 
     * Constructor for the TravelPackage class
     * @param String packageName the name of the package to be create
     * @param String description the description of the package to be created
     * @param int packageCost the cost of the package to be created
     * @param Vector<Destination> destinations the destinations in the package to be created
     * @return null
     */
    public TravelPackage(String packageName, String description, int passengerCapacity, int packageCost, Vector<Destination> destinations) {
        this.packageName = packageName;
        this.description = description;
        this.packageCost = packageCost;
        this.destinations = destinations;
        this.passengers = new Vector<Passenger>();
    }
    
     /** 
     * Constructor for the TravelPackage class
     * @param String packageName the name of the package to be create
     * @param String description the description of the package to be created
     * @param int packageCost the cost of the package to be created
     * @param Vector<Destination> destinations the destinations in the package to be created
     * @param Vector<Passenger> passengers the passengers in the package to be created
     * @return null
     */
    public TravelPackage(String packageName, String description, int passengerCapacity, int packageCost, Vector<Destination> destinations, Vector<Passenger> passengers) {
        this.packageName = packageName;
        this.description = description;
        this.packageCost = packageCost;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    
    /** 
     * Method to get the package name
     * @return String
     */
    public String getpackageName() {
        return this.packageName;
    }
    
    
    /** 
     * Method to get the package description
     * @return String
     */
    public String description() {
        return this.description;
    }
    
    
    /** 
     * Method to get the package cost
     * @return int
     */
    public int packageCost() {
        return this.packageCost;
    }

    
    /** 
     * Method to get the package's passenger capacity
     * @return int
     */
    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    /** 
     * Method to get the package's cost
     * @return int
     */
    public int getPackageCost() {
        return this.packageCost;
    }

    /** 
     * Method to get the package's description
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /** 
     * Method to get the package's destinations
     * @return Vector<Destination>
     */
    public Vector<Destination> getDestinations() {
        return this.destinations;
    }
    
    /** 
     * Method to get the package's passengers
     * @return Vector<Passenger>
     */
    public Vector<Passenger> getPassengers() {
        return this.passengers;
    }

    
    /** 
     * Method to add to the package's destination
     * @param Destination destination
     * @return null
     */
    public void addDestination(Destination destination) {
        this.destinations.add(destination);
    }

    
    /** 
     * Method to add a passenger to the package's passengers
     * @param Passenger passenger
     * @return null
     */
    public void addPassenger(Passenger passenger) {
        passenger.signUp(this);
        this.passengers.add(passenger);
    }


    /** 
     * Method to display passengers of the package
     * @return null
     */
    public void displayPassengers() {
        for(Passenger passenger :this.passengers) {
            System.out.println(passenger);
        }
    }

    /** 
     * Method to display the package
     * @return null
     */
    public void showPackage() {
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

    
    /** 
     * Method to show the package of the passenger
     * @param passenger
     * @return null
     */
    public void showPackages(Passenger passenger) {
        System.out.println("Name: " + this.packageName);
        System.out.println("Destinations and Activities: ");
        for(Destination destination : this.destinations) {
            System.out.println(destination.toString(passenger));
        }
    }

    
    /** 
     * Method to add passenger to the package
     * @param Passenger passenger
     * @return null
     */
    public void addMember(Passenger passenger) {
        this.passengers.add(passenger);
    }

    
    /** 
     * Method to check if the activity is in the package
     * @param Activity activity
     * @return null
     */
    public boolean findActivity(Activity activity) {
        for(Destination destination: this.destinations) {
            if(destination.findActivity(activity))
                return true;
        }
        return false;
    }


}
