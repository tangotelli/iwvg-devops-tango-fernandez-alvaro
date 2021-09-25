package es.upm.miw.iwvg_devops.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

    Fraction fraction;

    @BeforeEach
    void initializeTestData() {
        fraction = new Fraction(1, 3);
    }

    @Test
    void testGetNumerator() {
        Assertions.assertEquals(1, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        Assertions.assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(5);
        Assertions.assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(11);
        Assertions.assertEquals(11, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Assertions.assertEquals(0.3333, fraction.decimal(), 10e-5);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Fraction{numerator=1, denominator=3}", fraction.toString());
    }

    @Test
    void testIsProper() {
        Assertions.assertEquals(true, fraction.isProper());
        fraction.setNumerator(5);
        Assertions.assertEquals(false, fraction.isProper());
        fraction.setNumerator(3);
        Assertions.assertEquals(false, fraction.isProper());
    }

    @Test
    void testIsImproper() {
        Assertions.assertEquals(false, fraction.isImproper());
        fraction.setNumerator(9);
        Assertions.assertEquals(true, fraction.isImproper());
        fraction.setNumerator(3);
        Assertions.assertEquals(false, fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction equivalent = new Fraction(3, 9);
        Assertions.assertEquals(true, fraction.isEquivalent(equivalent));
        equivalent = new Fraction(2, 9);
        Assertions.assertEquals(false, fraction.isEquivalent(equivalent));
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(new Fraction(2, 3), fraction.add(fraction));
        Fraction newFraction = new Fraction(2, 5);
        Assertions.assertEquals(new Fraction(11, 15), fraction.add(newFraction));
    }

    @Test
    void testMultiply() {
        Fraction newFraction = new Fraction(2, 5);
        Assertions.assertEquals(new Fraction(2, 15), fraction.multiply(newFraction));
    }

    @Test
    void testDivide() {
        Fraction newFraction = new Fraction(2, 5);
        Assertions.assertEquals(new Fraction(5, 6), fraction.divide(newFraction));
    }
}
