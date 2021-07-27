import java.util.Vector;

public class Passenger {
    protected String name;
    protected int passengerId;
    protected int balance = 0;
    protected String membershipType;
    protected Vector<Activity> activities;
    
    Passenger(String name, int balance, String membershipType) {
        this.name = name;
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = new Vector<Activity>();
    }

    Passenger(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
        this.activities = new Vector<Activity>();
    }

    public String getName() {
        return this.name;
    }

    public int getPassengerId() {
        return this.passengerId;
    }

    public int getBalance() {
        if (this.membershipType == "PREMIUM")
            return Integer.MAX_VALUE;
        return this.balance;
    }

    @Override
    public String toString() {
        return Integer.toString(this.passengerId) + " " + this.name +" "+ Integer.toString(this.balance) + " " + this.membershipType;
    }

    public void getActivities() {
        
        for(Activity activity : this.activities) {
            System.out.println(activity.name + " " + activity.destination + " " + ( this.membershipType == "PREMIUM" ? 0 : activity.price ));
        }
    }

}
