package app;

import java.util.Vector;

public class Destination {
    private String name;
    private String description;
    private Vector<Activity> activities;

    Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    Destination(String name,  String description, Vector<Activity> activities) {
        this.name = name;
        this.description = description;
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activity.setDestination(this);
        if(!this.activities.contains(activity))
            this.activities.add(activity);
    }

    @Override
    public String toString() {
        String display = this.name + ": " + this.description + "\n";
        for(Activity activity: this.activities)
            display += activity.toString();
        return display;
    }

    public String toString(Passenger passenger) {
        String display = this.name + ": " + this.description + "\n";
        for(Activity activity: this.activities)
            display += activity.toString(passenger);
        return display;
    }
}
