package app;
import java.util.Vector;

public class Passenger {
    private String name;
    private int passengerId;
    private double balance;
    private String membershipType = "STANDARD";
    private Vector<TravelPackage> travelPackages;
    private Vector<Activity> activities;
    
    Passenger(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
        this.balance = 0;
        this.activities = new Vector<Activity>();
    }

    Passenger(String name, double balance, String membershipType) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = new Vector<Activity>();
        this.travelPackages = new Vector<TravelPackage>();
    }

    Passenger(String name, double balance, String membershipType, Vector<Activity> activities) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = activities;
        this.travelPackages = new Vector<TravelPackage>();
    }

    Passenger(String name, double balance, String membershipType, Vector<Activity> activities, Vector<TravelPackage> travelPackages) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = activities;
        this.travelPackages = travelPackages;
    }

    public String getName() {
        return this.name;
    }

    public int getPassengerId() {
        return this.passengerId;
    }

    public double getBalance() {
        if (this.membershipType == "PREMIUM")
            return Integer.MAX_VALUE;
        return this.balance;
    }

    @Override
    public String toString() {
        String display = "Id: " + Integer.toString(this.passengerId) + "\n" + 
                         "Name: " + this.name +"\n" +
                         "MembershipType: " + this.membershipType + "\n" + 
                         "Balance: " + (this.membershipType == "PREMIUM" ? "INFINITY" : Double.toString(this.balance)) + "\n";
        return display;
    }

    public void showPlans() {
        for(TravelPackage travelPackage: this.travelPackages) { 
            System.out.println("Travel Package: ");
            travelPackage.showPackages(this);
        }
    }

    public void getActivities() {
        for(Activity activity : this.activities) {
            System.out.println(activity);
        }
    }

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
    }

    public void signUp(Activity activity) {
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
    }
}
