package es.upm.miw.iwvg_devops.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class UserTest {

    User user;
    ArrayList<Fraction> fractions;

    @BeforeEach
    void initializeTestData() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 7));
        user = new User("id1", "Frank", "Lucas", fractions);
    }

    @Test
    void testGetId() {
        Assertions.assertEquals("id1", user.getId());
    }

    @Test
    void testGetName() {
        Assertions.assertEquals("Frank", user.getName());
    }

    @Test
    void testGetFamilyName() {
        Assertions.assertEquals("Lucas", user.getFamilyName());
    }

    @Test
    void testFullName() {
        Assertions.assertEquals("Frank Lucas", user.fullName());
    }

    @Test
    void testInitials() {
        Assertions.assertEquals("F.", user.initials());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("User{id='id1', name='Frank', familyName='Lucas'" +
                ", fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=7}]}",
                user.toString());
    }

    @Test
    void testSetName() {
        user.setName("Tim");
        Assertions.assertEquals("Tim", user.getName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Berners-Lee");
        Assertions.assertEquals("Berners-Lee", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        Assertions.assertEquals(fractions, user.getFractions());
    }

    @Test
    void testSetFractions() {
        ArrayList<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(9, 5));
        user.setFractions(newFractions);
        Assertions.assertEquals(newFractions, user.getFractions());
        Assertions.assertNotEquals(newFractions, this.fractions);
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction(1, 3);
        user.addFraction(fraction);
        Assertions.assertEquals(fraction, user.getFractions().get(user.getFractions().size() - 1));
    }
}
