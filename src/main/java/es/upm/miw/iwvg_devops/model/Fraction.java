package es.upm.miw.iwvg_devops.model;

import java.util.Objects;

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    public boolean isImproper() {
        return this.numerator > this.denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        return this.numerator * fraction.getDenominator() == this.denominator * fraction.getNumerator();
    }

    public Fraction add(Fraction fraction) {
        if (this.denominator != fraction.getDenominator()) {
            this.reduceToCommonDenominator(fraction);
        }
        return new Fraction(this.numerator + fraction.getNumerator(), this.denominator);
    }

    private void reduceToCommonDenominator(Fraction fraction) {
        int leastCommonMultiple = new MyMath().leastCommonMultiple(this.denominator, fraction.getDenominator());
        this.changeDenominator(leastCommonMultiple);
        fraction.changeDenominator(leastCommonMultiple);
    }

    public void changeDenominator(int newDenominator) {
        this.setNumerator((newDenominator / this.denominator) * this.numerator);
        this.setDenominator(newDenominator);
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(this.numerator * fraction.getNumerator(),
                this.denominator * fraction.getDenominator());
    }

    public Fraction divide(Fraction fraction) {
        return new Fraction(this.numerator * fraction.getDenominator(),
                this.denominator * fraction.getNumerator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
