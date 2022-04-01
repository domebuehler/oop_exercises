package ch.hslu.oop.sw06.unittests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdditionBothPositiv() {
        assertEquals(10, calculator.addition(5, 5));
    }

    @Test
    void testAdditionBothPositivAssertJ() {
        assertThat(calculator.addition(5, 5)).isEqualTo(10);
    }

    @Test
    void testAdditionBothNegativ() {
        assertEquals(-10, calculator.addition(-5, -5));
    }

    @Test
    void testAdditionBothZero() {
        assertEquals(0, calculator.addition(0, 0));
    }

    @Test
    void testAdditionFirstNegativ() {
        assertEquals(-5, calculator.addition(-10, 5));
    }

    @Test
    void testAdditionSecondNegativ() {
        assertEquals(-5, calculator.addition(5, -10));
    }

    @Test
    @Disabled
    void testAdditionMaxInt() {
        assertEquals((long) Integer.MAX_VALUE + Integer.MAX_VALUE,
                calculator.addition(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    @Disabled
    void testAdditionMinInt() {
        assertEquals((long) Integer.MIN_VALUE + Integer.MIN_VALUE,
                calculator.addition(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void testAdditionPositivIntOverflow() {
        assertEquals((long) Integer.MAX_VALUE + 1, calculator.addition(Integer.MAX_VALUE, 1));
    }

    @Test
    void testAdditionNegativIntOverflow() {
        assertEquals(Integer.MIN_VALUE - 1L, calculator.addition(Integer.MIN_VALUE, -1));
    }
}