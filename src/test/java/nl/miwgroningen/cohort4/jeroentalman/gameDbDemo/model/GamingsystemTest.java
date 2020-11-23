package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamingsystemTest {

    Gamingsystem gamingsystem;

    @BeforeEach
    void setUp() {
        gamingsystem = new Gamingsystem();
    }

    @Test
    void getName() {
        //arrange
        String expected = null;
        String actual = gamingsystem.getName();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting name");
    }

    @Test
    void setName() {
        //arrange
        String expected = "test";
        gamingsystem.setName(expected);

        //no act

        //assert
        assertEquals(expected, gamingsystem.getName(), "Error setting name");
    }

    @Test
    void getYear() {
        //arrange
        Integer expected = null;
        Integer actual = gamingsystem.getYear();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting year");
    }

    @Test
    void setYear() {
        //arrange
        Integer expected = 2020;
        gamingsystem.setYear(2020);

        //no act

        //assert
        assertEquals(expected, gamingsystem.getYear(), "Error setting year");
    }

    @Test
    void setYearInvalid() {
        try {
            gamingsystem.setYear(1969);
            fail("er had een foutmelding gegooid moeten worden");
        } catch (IllegalArgumentException exception) {
            System.out.println("foutmelding succesvol afgevangen");
        } catch (Exception exception) {
            fail("Hier had een specifieke foutmelding moeten staan");
        }
    }

    @Test
    void getLogoUrl() {
        //arrange
        String expected = null;
        String actual = gamingsystem.getLogoUrl();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setLogoUrl() {
        //arrange
        String expected = "testurl";
        gamingsystem.setLogoUrl(expected);

        //assert
        assertEquals(expected, gamingsystem.getLogoUrl());
    }

    @Test
    void testToString(){
        //arrange
        String name = "testsystem";
        Integer year = 1997;
        String expected = String.format("Name system: %s, released in year: %d", name, year);

        //act
        gamingsystem.setName(name);
        gamingsystem.setYear(year);
        String resultaat = gamingsystem.toString();

        //assert
        assertEquals(expected, resultaat);
    }
}