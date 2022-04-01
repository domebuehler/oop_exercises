package ch.hslu.oop.rep.temp;

import ch.hslu.oop.rep.element.ElementEnum;
import ch.hslu.oop.rep.element.StateOfAggregation;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class TemperatureTest {

    private final static float TOLERANCE = 0.1f;

    @Test
    public void testDefaultConstructor() {
        Temperature temperature = new Temperature();
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(20f, within(TOLERANCE));
    }

    @Test
    public void testConstructor() {
        Temperature temperature = new Temperature(50f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(50f, within(TOLERANCE));
    }

    @Test
    public void testSetTemperatureInCelsius() {
        Temperature temperature = new Temperature(50f);
        temperature.setTemperatureInCelsius(100f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(100f, within(TOLERANCE));
    }

    @Test
    public void testConvertKelvinToCelsius() {
        float converted = Temperature.convertKelvinToCelsius(400f);
        assertThat(converted).isCloseTo(126.85f, within(TOLERANCE));
    }

    @Test
    public void testConvertCelsiusToKelvin() {
        float converted = Temperature.convertCelsiusToKelvin(100f);
        assertThat(converted).isCloseTo(373.15f, within(TOLERANCE));
    }

    @Test
    public void testConvertFahrenheitToCelsius() {
        float converted = Temperature.convertFahrenheitToCelsius(100f);
        assertThat(converted).isCloseTo(37.78f, within(TOLERANCE));
    }

    @Test
    public void testConvertCelsiusToFahrenheit() {
        float converted = Temperature.convertCelsiusToFahrenheit(50f);
        assertThat(converted).isCloseTo(122f, within(TOLERANCE));
    }

    @Test
    public void testAdjustTemperatureInCelsiusFromPositivCelsiusValue() {
        Temperature temperature = new Temperature(50f);
        temperature.adjustTemperatureInCelsiusFromCelsiusValue(50f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(100f, within(TOLERANCE));
    }

    @Test
    public void testAdjustTemperatureInCelsiusFromNegativeCelsiusValue() {
        Temperature temperature = new Temperature(50f);
        temperature.adjustTemperatureInCelsiusFromCelsiusValue(-50f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(0, within(TOLERANCE));
    }

    @Test
    public void testAdjustTemperatureInCelsiusFromKelvinValue() {
        Temperature temperature = new Temperature(50f);
        temperature.adjustTemperatureInCelsiusFromKelvinValue(300f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(76.85f, within(TOLERANCE));
    }

    @Test
    public void testAdjustTemperatureInCelsiusFromPositiveFahrenheitValue() {
        Temperature temperature = new Temperature(50f);
        temperature.adjustTemperatureInCelsiusFromFahrenheitValue(122f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(100f, within(TOLERANCE));
    }

    @Test
    public void testAdjustTemperatureInCelsiusFromNegativeFahrenheitValue() {
        Temperature temperature = new Temperature(50f);
        temperature.adjustTemperatureInCelsiusFromFahrenheitValue(-58f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(0, within(TOLERANCE));
    }

    @Test
    public void testGetStateOfAggregationMercury() {
        Temperature temperature = new Temperature(400f);
        StateOfAggregation state = temperature.getStateOfAggregation(ElementEnum.MERCURY);
        assertThat(state).isEqualTo(StateOfAggregation.GASEOUS);
    }

    @Test
    public void testGetStateOfAggregationLead() {
        Temperature temperature = new Temperature(10f);
        StateOfAggregation state = temperature.getStateOfAggregation(ElementEnum.LEAD);
        assertThat(state).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testGetStateOfAggregationNitrogen() {
        Temperature temperature = new Temperature(-200f);
        StateOfAggregation state = temperature.getStateOfAggregation(ElementEnum.NITROGEN);
        assertThat(state).isEqualTo(StateOfAggregation.FLUID);
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testCompareToBigger() {
        Temperature temp1 = new Temperature(20f);
        Temperature temp2 = new Temperature(10f);

        assertThat(temp1.compareTo(temp2)).isPositive();
    }

    @Test
    public void testCompareToSmaller() {
        Temperature temp1 = new Temperature(20f);
        Temperature temp2 = new Temperature(10f);

        assertThat(temp2.compareTo(temp1)).isNegative();
    }

    @Test
    public void testCompareToEquals() {
        Temperature temp1 = new Temperature(20f);
        Temperature temp2 = new Temperature(20f);

        assertThat(temp1.compareTo(temp2)).isEqualTo(0);
    }
}