package ch.hslu.oop.sw03;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class DemoTest {

    @Test
    public void testMaximum() {
        Demo tester = new Demo();
        assertEquals("10 is bigger than 5", 10, tester.maximum(10, 5));
    }

    @Test
    public void testQuotient() {
        Demo tester = new Demo();
        assertEquals("10/5 is 2", 2, tester.quotient(10, 5));
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown(){
        Demo tester = new Demo();
        tester.quotient(10,0);
    }*/

    @Test
    public void testMin() {
        Demo tester = new Demo();
        assertEquals("5 is smaller than 10", 5, tester.min(10, 5));
    }

    @Test
    public void testMax1() {
        Demo tester = new Demo();
        assertEquals("100 is bigger than 10 and 5", 100, tester.max1(10, 5, 100));
    }

    @Test
    public void testMax2() {
        Demo tester = new Demo();
        assertEquals("100 is bigger than 10 and 5", 100, tester.max2(5, 10, 100));
    }

    @Test
    public void testMax5() {
        Demo tester = new Demo();
        assertEquals("999 is the biggest number", 999, tester.max5(888, 777, 34, 999, 199));
    }
}