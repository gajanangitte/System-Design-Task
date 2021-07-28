package tests;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import app.Destination;
import app.Passenger;
import app.Activity;



public class ActivityUnitTest extends TestCase {
    private Activity activity;
    private Destination destination;

    @Before
    protected void setUp() throws Exception {
        destination = new Destination("Dest1", "DestDes 1" );
        this.activity = new Activity("Act1", "Desc 1", destination, 100, 10 );
    }

    @Test
    public void testCheckBasicParams() throws Exception {
        assertEquals("Act1", this.activity.getName());
        assertEquals("Desc 1", this.activity.getDescription());
        assertEquals( this.destination, this.activity.getDestination());
        assertEquals(100, this.activity.getPrice());
        assertEquals(10, this.activity.getCapacity());
                
    }

    @Test
    public void testPassengerFeature() throws Exception {
        Passenger passS = new Passenger("PassS", "STANDARD", 1000);
        Passenger passF = new Passenger("PassF", "STANDARD", 1000);
        
        this.activity.addMember(passS);
        assertEquals(true, this.activity.isPassenger(passS));
        assertEquals(false, this.activity.isPassenger(passF));
        
    }

    public void testDestinationFeature() throws Exception {
        Destination tempDest = new Destination("Dest2", "DestDes 2" );
        this.activity.setDestination(tempDest);
        assertEquals(tempDest, this.activity.getDestination());
        assertNotEquals(this.destination, this.activity.getDestination());
    }

}