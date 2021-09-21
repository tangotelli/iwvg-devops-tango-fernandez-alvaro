package es.upm.miw.iwvg_devops.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class UserTest {

    private User user;
    ArrayList<Fraction> fractions;

    @BeforeEach
    public void initializeTestData() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 7));
        user = new User("id1", "Frank", "Lucas", fractions);
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals("id1", user.getId());
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Frank", user.getName());
    }

    @Test
    public void testGetFamilyName() {
        Assertions.assertEquals("Lucas", user.getFamilyName());
    }

    @Test
    public void testFullName() {
        Assertions.assertEquals("Frank Lucas", user.fullName());
    }

    @Test
    public void testInitials() {
        Assertions.assertEquals("F.", user.initials());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("User{id='id1', name='Frank', familyName='Lucas'" +
                ", fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=7}]}",
                user.toString());
    }

    @Test
    public void testSetName() {
        user.setName("Tim");
        Assertions.assertEquals("Tim", user.getName());
    }

    @Test
    public void testSetFamilyName() {
        user.setFamilyName("Berners-Lee");
        Assertions.assertEquals("Berners-Lee", user.getFamilyName());
    }

    @Test
    public void testGetFractions() {
        Assertions.assertEquals(fractions, user.getFractions());
    }

    @Test
    public void testSetFractions() {
        ArrayList<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(9, 5));
        user.setFractions(newFractions);
        Assertions.assertEquals(newFractions, user.getFractions());
        Assertions.assertNotEquals(newFractions, this.fractions);
    }

    @Test
    public void testAddFraction() {
        Fraction fraction = new Fraction(1, 3);
        user.addFraction(fraction);
        Assertions.assertEquals(fraction, user.getFractions().get(user.getFractions().size() - 1));
    }
}
