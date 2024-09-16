package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private List<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        user = new User("1", "Jorge", "Alvarez", fractions);
    }

    @Test
    void testUserCreation() {
        assertEquals("1", user.getId());
        assertEquals("Jorge", user.getName());
        assertEquals("Alvarez", user.getFamilyName());
        assertEquals(2, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("Jorge Alvarez", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testSetName() {
        user.setName("Andres");
        assertEquals("Andres", user.getName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Melchor");
        assertEquals("Melchor", user.getFamilyName());
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(5, 6);
        user.addFraction(newFraction);
        assertEquals(3, user.getFractions().size());
        assertTrue(user.getFractions().contains(newFraction));
    }

    @Test
    void testEmptyConstructor() {
        User emptyUser = new User();
        assertNotNull(emptyUser.getFractions());
        assertEquals(0, emptyUser.getFractions().size());
    }

    @Test
    void testToString() {
        String expectedString = "User{id='1', name='Jorge', familyName='Alvarez', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=4}]}";
        assertEquals(expectedString, user.toString());
    }
}
