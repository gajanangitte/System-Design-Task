package tests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import app.TravelPackage;
import app.Passenger;
import app.Activity;
import app.Destination;


/**
* Unit test file for Passenger class
* 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/
public class PassengerUnitTest extends TestCase {
    private Passenger passengerStandard, passengerGold, passengerPremium;
    private TravelPackage travelPackage;
    private Activity activity;
    private Destination destination;

    @Before
    protected void setUp() throws Exception {
        this.destination = new Destination("Dest1", "Desc 1" );
        this.travelPackage = new TravelPackage("TP0", "Desc TP0", 100, 10 );
        this.travelPackage.addDestination(this.destination);
        this.activity = new Activity("Act1", "Desc 1", this.destination, 100, 10 );
        this.destination.addActivity(activity);
        this.passengerStandard = new Passenger("PassS", "STANDARD", 1000);
        this.passengerGold = new Passenger("PassG", "GOLD", 1000);
        this.passengerPremium = new Passenger("PassP", "PREMIUM", 1000);

    }

    @Test
    public void testCheckBasicParams() throws Exception {

        assertEquals("PassS", this.passengerStandard.getName());
        assertEquals("PassG", this.passengerGold.getName());
        assertEquals("PassP", this.passengerPremium.getName());

        assertEquals("STANDARD", this.passengerStandard.getMembershipType());
        assertEquals("GOLD", this.passengerGold.getMembershipType());
        assertEquals("PREMIUM", this.passengerPremium.getMembershipType());
        
        assertEquals(Double.valueOf(1000), this.passengerStandard.getBalance());
        assertEquals(Double.valueOf(1000), this.passengerGold.getBalance());
        assertEquals(Double.valueOf(1000), this.passengerPremium.getBalance());
    }

    @Test
    public void testPassengerStandardFeatures() throws Exception {
        this.passengerStandard.signUp(this.travelPackage);
        assertEquals(Double.valueOf(900), this.passengerStandard.getBalance());
        assertEquals(this.travelPackage, this.passengerStandard.getTravelPackages().get(0));
        
        
        this.passengerStandard.signUp(this.activity);
        assertEquals(Double.valueOf(800), this.passengerStandard.getBalance());
        assertEquals(this.activity, this.passengerStandard.getActivities().get(0));
    }

    @Test
    public void testPassengerGoldFeatures() throws Exception {
        this.passengerGold.signUp(this.travelPackage);
        assertEquals(Double.valueOf(910), this.passengerGold.getBalance());
        assertEquals(this.travelPackage, this.passengerGold.getTravelPackages().get(0));
        
        
        this.passengerGold.signUp(this.activity);
        assertEquals(Double.valueOf(820), this.passengerGold.getBalance());
        assertEquals(this.activity, this.passengerGold.getActivities().get(0));
    }

    @Test
    public void testPassengerPremiumFeatures() throws Exception {
        this.passengerPremium.signUp(this.travelPackage);
        assertEquals(Double.valueOf(1000), this.passengerPremium.getBalance());
        assertEquals(this.travelPackage, this.passengerPremium.getTravelPackages().get(0));
        
        
        this.passengerPremium.signUp(this.activity);
        assertEquals(Double.valueOf(1000), this.passengerPremium.getBalance());
        assertEquals(this.activity, this.passengerPremium.getActivities().get(0));
    }

}