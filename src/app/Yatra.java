package app;

/**
* The Yatra file implements the interface for
* the system display and operational parts. 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/
public class Yatra {

    /**
     * {@code int numberOfPassengers} is the number of users in the systems
     */
    int numberOfPassengers = 0;

    
    /** 
     * This method is called to get the number of total passengers in the system.
     * @return int
     */
    int getNumberOfPassengerId() {
        this.numberOfPassengers++;
        return this.numberOfPassengers;
    }

    
    /** 
     * This the main entry point for the system.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Yatra!");
        System.out.println("While For Loop to add TravelPackages, Passengers, Activities, Destination");
    }
}
