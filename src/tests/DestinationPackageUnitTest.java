package tests;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import app.Destination;
import app.Activity;

public class DestinationPackageUnitTest extends TestCase {
    private Destination destination;

    @Before
    protected void setUp() throws Exception {
        this.destination = new Destination("Dest1", "Desc 1" );
    }

    @Test
    public void testCheckBasicParams() throws Exception {
        assertEquals("Dest1", this.destination.getDestinationName());
        assertEquals("Desc 1", this.destination.getDescription());
    }

    @Test
    public void testActivityFeature() throws Exception {
        Activity activity1 = new Activity("Act1", "DescAct1", destination, 0, 10 );
        this.destination.addActivity(activity1);
        assertEquals(true, this.destination.findActivity(activity1));

        Activity activity2 = new Activity("Act2", "DescAct2", destination, 0, 10 );
        assertNotEquals(activity2, this.destination.findActivity(activity2));
        
    }
}