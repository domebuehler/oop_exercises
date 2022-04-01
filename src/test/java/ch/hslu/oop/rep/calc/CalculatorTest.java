package ch.hslu.oop.rep.calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void testAdditionTwoZero() {
        Additionable calc = new Calculator();
        long result = calc.addition(0, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testAdditionOneZero() {
        Additionable calc = new Calculator();
        long result = calc.addition(10, 0);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void testAdditionTwoPositivValues() {
        Additionable calc = new Calculator();
        long result = calc.addition(200, 300);
        assertThat(result).isEqualTo(500);
    }

    @Test
    void testAdditionTwoNegativValues() {
        Additionable calc = new Calculator();
        long result = calc.addition(-100, -150);
        assertThat(result).isEqualTo(-250);
    }

    @Test
    void testAdditionFirstNegativSecondPositiv() {
        Additionable calc = new Calculator();
        long result = calc.addition(-100, 150);
        assertThat(result).isEqualTo(50);
    }

    @Test
    void testAdditionFirstPositivSecondNegativ() {
        Additionable calc = new Calculator();
        long result = calc.addition(500, -300);
        assertThat(result).isEqualTo(200);
    }

    @Test
    void testAdditionBiggestIntegers() {
        Additionable calc = new Calculator();
        long result = calc.addition(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertThat(result).isEqualTo((long) Integer.MAX_VALUE + Integer.MAX_VALUE);
    }

    @Test
    void testAdditionSmallestIntegers() {
        Additionable calc = new Calculator();
        long result = calc.addition(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertThat(result).isEqualTo((long) Integer.MIN_VALUE + Integer.MIN_VALUE);
    }
}