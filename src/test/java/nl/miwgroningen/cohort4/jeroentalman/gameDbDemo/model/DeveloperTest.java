package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    Developer developer;

    @BeforeEach
    void setUp() {
        developer = new Developer();
    }

    @Test
    void getName() {
        //arrange
        String expected = null;
        String actual = developer.getName();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting name");
    }

    @Test
    void setName() {
        //arrange
        String expected = "test";
        developer.setName(expected);

        //no act

        //assert
        assertEquals(expected, developer.getName(), "Error setting name");
    }

    @Test
    void getYearFounded() {
        //arrange
        Integer expected = null;
        Integer actual = developer.getYearFounded();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting year founded");
    }

    @Test
    void setYearFounded() {
        //arrange
        Integer expected = 2020;
        developer.setYearFounded(expected);

        //no act

        //assert
        assertEquals(expected, developer.getYearFounded(), "Error setting year founded");
    }

    @Test
    void setYearFoundedInvalid() {
        try {
            developer.setYearFounded(1879);
            fail("er had een foutmelding gegooid moeten worden");
        } catch (IllegalArgumentException exception) {
            System.out.println("foutmelding succesvol afgevangen");
        } catch (Exception exception) {
            fail("Hier had een specifieke foutmelding moeten staan");
        }
    }

    @Test
    void getActive() {
        //arrange
        Boolean expected = false;
        Boolean actual = developer.getActive();

        //no act

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setActive() {
        //arrange
        Boolean expected = true;
        developer.setActive(expected);

        //assert
        assertEquals(expected, developer.getActive());
    }

    @Test
    void getLogoUrl() {
        //arrange
        String expected = null;
        String actual = developer.getLogoUrl();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setLogoUrl() {
        //arrange
        String expected = "testurl";
        developer.setLogoUrl(expected);

        //assert
        assertEquals(expected, developer.getLogoUrl());
    }

    @Test
    void testToString() {
        //arrange
        String name = "testdeveloper";
        Integer year = 1997;
        Boolean active = true;
        String expected = String.format("name: %s, founded in: %d, still active: %s", name, year, active);

        //act
        developer.setName(name);
        developer.setYearFounded(year);
        developer.setActive(active);
        String resultaat = developer.toString();

        //assert
        assertEquals(expected, resultaat);
    }
}