package es.upm.miw.iwvg_devops.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FractionTest {

    Fraction fraction;

    @BeforeEach
    public void initializeTestData() {
        fraction = new Fraction(1, 3);
    }

    @Test
    public void testGetNumerator() {
        Assertions.assertEquals(1, fraction.getNumerator());
    }

    @Test
    public void testGetDenominator() {
        Assertions.assertEquals(3, fraction.getDenominator());
    }

    @Test
    public void testSetNumerator() {
        fraction.setNumerator(5);
        Assertions.assertEquals(5, fraction.getNumerator());
    }

    @Test
    public void testSetDenominator() {
        fraction.setDenominator(11);
        Assertions.assertEquals(11, fraction.getDenominator());
    }

    @Test
    public void testDecimal() {
        Assertions.assertEquals(0.3333, fraction.decimal(), 10e-5);
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("Fraction{numerator=1, denominator=3}", fraction.toString());
    }
}
