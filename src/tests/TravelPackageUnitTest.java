package tests;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import app.Destination;
import app.Passenger;
import app.TravelPackage;

/**
* Unit test file for TravelPackage class
* 
*
* @author  Apricot
* @version 1.0
* @since   2020-07-28
*/

public class TravelPackageUnitTest extends TestCase {
    private TravelPackage travelPackage;

    @Before
    protected void setUp() throws Exception {
        this.travelPackage = new TravelPackage("TP0", "Desc TP0", 100, 10 );
    }

    @Test
    public void testCheckBasicParams() throws Exception {
        assertEquals("TP0", this.travelPackage.getpackageName());
        assertEquals(10, this.travelPackage.getPassengerCapacity());
        assertEquals(100, this.travelPackage.getPackageCost());
        assertEquals("Desc TP0", this.travelPackage.getDescription());
    }

    @Test
    public void testDestinationFeature() throws Exception {
        Destination destination = new Destination("Des0", "Desc Des0");
        this.travelPackage.addDestination(destination);
        assertEquals(destination, this.travelPackage.getDestinations().get(0));
    }

    @Test
    public void testPassengerFeature() throws Exception {
        Passenger passS = new Passenger("PassS", "STANDARD", 1000);
        this.travelPackage.addPassenger(passS);
        assertEquals(passS, this.travelPackage.getPassengers().get(0));

        Passenger passF = new Passenger("PassF", "STANDARD", 1);
        this.travelPackage.addPassenger(passF);
        assertNotEquals(passF, this.travelPackage.getPassengers().get(1));
    }
}