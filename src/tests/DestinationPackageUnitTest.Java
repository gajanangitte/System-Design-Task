package tests;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import app.Destination;
import app.Passenger;
import app.TravelPackage;
import app.Activity;



public class DestinationPackageUnitTest extends TestCase {
    private Destination destination;

    @Before
    protected void setUp() throws Exception {
        this.destination = new Destination("Dest1", "Desc 1" );
    }

    @Test
    public void testCheckBasicParams() throws Exception {
        assertEquals("Dest1", this.destination.getDestinaionName());
        assertEquals("Desc 1", this.destination.getDescription());
    }

    @Test
    public void testActivityFeature() throws Exception {
        Activity activity1 = new Activity("Act1", "DescAct1", this, 0, 10 );
        this.destination.addActivity(activity1);
        assertEquals(true, this.travelPackage.findActivity(activity1));

        Activity activity2 = new Activity("Act2", "DescAct2", this, 0, 10 );
        assertNotEquals(activity2, this.travelPackage.findActivity(activity2));
        
    }
}