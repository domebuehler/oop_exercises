package ch.hslu.oop.sw06.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoTest {

    @Test
    void testMaximumBiggerNumberFirst() {
        assertEquals(10,
                Demo.maximum(10, 5), "10 is bigger than 5");
    }

    @Test
    void testMaximumSmallerNumberFirst() {
        assertEquals(25,
                Demo.maximum(15, 25), "25 is bigger than 15");
    }

    @Test
    void textMaximumEqualsNumbers() {
        assertEquals(30,
                Demo.maximum(30, 30), "Should be 30 because Numbers are equal");
    }
}