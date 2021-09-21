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

    @Test
    public void testIsProper() {
        Assertions.assertEquals(true, fraction.isProper());
        fraction.setNumerator(5);
        Assertions.assertEquals(false, fraction.isProper());
        fraction.setNumerator(3);
        Assertions.assertEquals(false, fraction.isProper());
    }

    @Test
    public void testIsImproper() {
        Assertions.assertEquals(false, fraction.isImproper());
        fraction.setNumerator(9);
        Assertions.assertEquals(true, fraction.isImproper());
        fraction.setNumerator(3);
        Assertions.assertEquals(false, fraction.isImproper());
    }

    @Test
    public void testIsEquivalent() {
        Fraction equivalent = new Fraction(3, 9);
        Assertions.assertEquals(true, fraction.isEquivalent(equivalent));
        equivalent = new Fraction(2, 9);
        Assertions.assertEquals(false, fraction.isEquivalent(equivalent));
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(new Fraction(2, 3), fraction.add(fraction));
        Fraction newFraction = new Fraction(2, 5);
        Assertions.assertEquals(new Fraction(11, 15), fraction.add(newFraction));
    }

    @Test
    public void testMultiply() {
        Fraction newFraction = new Fraction(2, 5);
        Assertions.assertEquals(new Fraction(2, 15), fraction.multiply(newFraction));
    }

    @Test
    public void testDivide() {
        Fraction newFraction = new Fraction(2, 5);
        Assertions.assertEquals(new Fraction(5, 6), fraction.divide(newFraction));
    }
}
