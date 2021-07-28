package app;
import java.util.Vector;

/**
* The Passenger class contains all the travel details
* to for a passenger. It can manipulate and
* modify travel activities, packages of the traveler.
* 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/

public class Passenger {

    /**
     * Variables
     * {@code String name} is the name of the passenger.
     * {@code int passengerId} is the passengerId of the passenger.
     * {@code double balance} is the balance of the passenger.
     * {@code String membershipType} is the membership type of the passenger. Can be either: STANDARD, or GOLD, or PREMIUM
     * {@code Vector<TravelPackage> travelPackages} travelPackages enlisted by the passenger.
     * {@code Vector<Activity> activities} activities by the passenger.
     * 
    */
    private String name;
    private int passengerId;
    private double balance;
    private String membershipType = "STANDARD";
    private Vector<TravelPackage> travelPackages;
    private Vector<Activity> activities;
    
    /** 
     * Constructor for the Activity class
     * @param String name the name of the passenger to be created
     * @param String membershipType the membershipType of the passenger to be created
     * @param int balance the BALANCE of the passenger to be created
     * @param Vector<Activity> activities the activities of passengers enlisted
     * @return null
     */ 
    Passenger(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
        this.balance = 0;
        this.activities = new Vector<Activity>();
    }

    /** 
     * Constructor for the Activity class
     * @param String name the name of the passenger to be created
     * @param String membershipType the membershipType of the passenger to be created
     * @param double balance the BALANCE of the passenger to be created
     * @return null
     */ 
    Passenger(String name, double balance, String membershipType) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = new Vector<Activity>();
        this.travelPackages = new Vector<TravelPackage>();
    }

    /** 
     * Constructor for the Activity class
     * @param String name the name of the passenger to be created
     * @param String membershipType the membershipType of the passenger to be created
     * @param double balance the BALANCE of the passenger to be created
     * @param Vector<Activity> activities the activities of passengers enlisted
     * @return null
     */ 
    Passenger(String name, double balance, String membershipType, Vector<Activity> activities) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = activities;
        this.travelPackages = new Vector<TravelPackage>();
    }

    /** 
     * Constructor for the Activity class
     * @param String name the name of the passenger to be created
     * @param String membershipType the membershipType of the passenger to be created
     * @param double balance the BALANCE of the passenger to be created
     * @param Vector<Activity> activities the activities of passengers enlisted
     * @param Vector<TravelPackage> travel packages of the activities the passengers enlisted in
     * @return null
     */ 
    Passenger(String name, double balance, String membershipType, Vector<Activity> activities, Vector<TravelPackage> travelPackages) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = activities;
        this.travelPackages = travelPackages;
    }

    
    /** 
     * Method to get the name of the passenger
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * Method to get the passenger id of the passenger
     * @return int
     */
    public int getPassengerId() {
        return this.passengerId;
    }

    
    /** 
     * Method to get the balance of the passenger
     * @return double
     */
    public double getBalance() {
        if (this.membershipType == "PREMIUM")
            return Integer.MAX_VALUE;
        return this.balance;
    }

    
    /** 
     * Method to Stringify the passenger
     * @return String
     */
    @Override
    public String toString() {
        String display = "Id: " + Integer.toString(this.passengerId) + "\n" + 
                         "Name: " + this.name +"\n" +
                         "MembershipType: " + this.membershipType + "\n" + 
                         "Balance: " + (this.membershipType == "PREMIUM" ? "INFINITY" : Double.toString(this.balance)) + "\n";
        return display;
    }

    /** 
     * Method to display all the travelPackages of the passenger
     * @return null
     */
    public void showPlans() {
        for(TravelPackage travelPackage: this.travelPackages) { 
            System.out.println("Travel Package: ");
            travelPackage.showPackages(this);
        }
    }

    /** 
     * Method to display all the activities of the passenger
     * @return null
     */
    public void getActivities() {
        for(Activity activity : this.activities) {
            System.out.println(activity);
        }
    }

    
    /** 
     * Method to sign up for a given travelPackage if the passenger has sufficient balance
     * @param travelPackage
     */
    public void signUp(TravelPackage travelPackage) {
        if(this.travelPackages.contains(travelPackage)) {
            System.out.println("Package Already Signed Up for!");
            return;
        } 
        if(travelPackage.getPassengerCapacity() == travelPackage.getPassengers().size()) {
            System.out.println("Package Full");
            return;
        }
        double price;
        if(this.membershipType == "PREMIUM") {
            price = 0;
        }
        else if(this.membershipType == "GOLD") {
            price = travelPackage.packageCost() * 0.9;
        }
        else {
            price = travelPackage.packageCost();
        };
        if(this.balance >= price) {
            this.balance -= price;
            this.travelPackages.add(travelPackage);
            travelPackage.addMember(this);
        }
        else {
            System.out.println("Insufficient Balance");
        }
        return;
    }

    
    /** 
     * Method to sign Up for an activity if the passenger has enrolled in the travel packages and has sufficient balance
     * @param activity
     */
    public void signUp(Activity activity) {

        boolean activityFound = false;
        for(TravelPackage travelPackages : travelPackages) {
            activityFound = activityFound || travelPackages.findActivity(activity);
        }

        if(activityFound) { 
            if(this.activities.contains(activity)) {
                System.out.println("Activity Already Signed Up for!");
                return;
            } 
            if(activity.getCapacity() == activity.getTourists()) {
                System.out.println("Activity Full");
                return;
            }
            double price;
            if(this.membershipType == "PREMIUM") {
                price = 0;
            }
            else if(this.membershipType == "GOLD") {
                price = activity.getPrice() * 0.9;
            }
            else {
                price = activity.getPrice();
            };
            if(this.balance >= price) {
                this.balance -= price;
                this.activities.add(activity);
                activity.addMember(this);
            }
            else {
                System.out.println("Insufficient Balance");
            }
            return;
        } else {
            System.out.println("No Destination for Activity in Travel Packages");
        }
    }
    
}
