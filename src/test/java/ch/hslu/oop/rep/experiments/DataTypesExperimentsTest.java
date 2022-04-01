package ch.hslu.oop.rep.experiments;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class DataTypesExperimentsTest {

    private final static Float TOLERANCE = 0.1f;

    @Test
    public void testMaxInt() {
        int testInt = DataTypesExperiments.returnMaxInt();
        assertThat(testInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void testMaxIntPlusOne() {
        int testInt = DataTypesExperiments.returnMaxIntPlusOne();
        assertThat(testInt).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testMinIntMinusOne() {
        int testInt = DataTypesExperiments.returnMinIntMinusOne();
        assertThat(testInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void testMaxFloatPlusOne() {
        float testFloat = DataTypesExperiments.returnMaxFloatPlusOne();
        assertThat(testFloat).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    public void testMaxFloatAddWithEffect() {
        float testFloat = DataTypesExperiments.returnMaxFloatAddWithEffect();
        assertThat(testFloat).isNotEqualTo(Float.MAX_VALUE);
    }

    @Test
    public void testReturnCorrectResult() {
        float result = DataTypesExperiments.returnCorrectResult();
        assertThat(result).isCloseTo(4.5f, within(TOLERANCE));
    }

    @Test
    public void testReturnFalseResult() {
        float result = DataTypesExperiments.returnFalseResult();
        assertThat(result).isCloseTo(4f, within(TOLERANCE));
    }
}