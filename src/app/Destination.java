package app;

import java.util.Vector;

/**
* The Destination class contains all the travel destinations
* to be used by the Travel System. It can manipulate and
* modify travel activities.
* 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/
public class Destination {
    /**
     * Variables
     * {@code String name} is the name of the destination.
     * {@code String description} is the description of the destination.
    */
    private String name;
    private String description;
    private Vector<Activity> activities;

    /** 
     * Constructor for the Destination class
     * @param String name the name of the destination to be created
     * @param String description the description of the destination to be created
     * @param int packageCost the cost of the destination to be created
     * @return null
     */    
    public Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /** 
     * Constructor for the Destination class
     * @param String name the name of the destination to be created
     * @param String description the description of the destination to be created
     * @param int packageCost the cost of the destination to be created
     * @return null
     */    
    public Destination(String name,  String description, Vector<Activity> activities) {
        this.name = name;
        this.description = description;
        this.activities = activities;
    }

    /** 
     * Method to get the destination's name
     * @return String
     */
    public String getDestinationName() {
        return this.name;
    }

    /** 
     * Method to get the destination's description
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
    
    /** 
     * Method to add a new activity to a list of activities
     * @param activity
     */
    public void addActivity(Activity activity) {
        activity.setDestination(this);
        if(!this.activities.contains(activity))
            this.activities.add(activity);
    }

    
    /** 
     * Method to convert object to string
     * @return String
     */
    @Override
    public String toString() {
        String display = this.name + ": " + this.description + "\n";
        for(Activity activity: this.activities)
            display += activity.toString();
        return display;
    }

    
    /** 
     * Method to get activities in accordance with the param passenger
     * @param passenger
     * @return String
     */
    public String toString(Passenger passenger) {
        String display = this.name + ": " + this.description + "\n";
        for(Activity activity: this.activities)
            display += activity.toString(passenger);
        return display;
    }

    
    /** 
     * Method to find activity from a destination's activity list
     * @param activity
     * @return boolean
     */
    public boolean findActivity(Activity activity) {
        return this.activities.contains(activity);
    }
}
