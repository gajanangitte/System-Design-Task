import java.util.Hashtable;

public class Yatra {

    public Hashtable<String, Double> membershipType = new Hashtable<String, Double>();
    int numberOfPassengers = 0;

    int getNumberOfPassengerId() {
        this.numberOfPassengers++;
        return this.numberOfPassengers;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Yatra!");
        
    }
}
