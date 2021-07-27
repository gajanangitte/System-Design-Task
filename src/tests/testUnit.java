package tests;

import junit.framework.TestCase;


public class testUnit extends TestCase {
    protected int value;

    protected void setUp() throws Exception {
        value = 5;
    }

    public void testCheck() throws Exception {
        assertTrue(value == 5);
    }
}