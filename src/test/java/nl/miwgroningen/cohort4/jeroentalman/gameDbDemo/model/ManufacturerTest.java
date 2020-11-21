package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

    Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer();
    }

    @Test
    void getName() {
        //arrange
        String expected = null;
        String actual = manufacturer.getName();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting name");
    }

    @Test
    void setName() {
        //arrange
        String expected = "test";
        manufacturer.setName(expected);

        //no act

        //assert
        assertEquals(expected, manufacturer.getName(), "Error setting name");
    }

    @Test
    void getYearFounded() {
        //arrange
        Integer expected = null;
        Integer actual = manufacturer.getYearFounded();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting year founded");
    }

    @Test
    void setYearFounded() {
        //arrange
        Integer expected = 2020;
        manufacturer.setYearFounded(expected);

        //no act

        //assert
        assertEquals(expected, manufacturer.getYearFounded(), "Error setting year founded");
    }

    @Test
    void setYearFoundedInvalid() {
        try {
            manufacturer.setYearFounded(1879);
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
        Boolean actual = manufacturer.getActive();

        //no act

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setActive() {
        //arrange
        Boolean expected = true;
        manufacturer.setActive(expected);

        //assert
        assertEquals(expected, manufacturer.getActive());
    }

    @Test
    void getLogoUrl() {
        //arrange
        String expected = null;
        String actual = manufacturer.getLogoUrl();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setLogoUrl() {
        //arrange
        String expected = "testurl";
        manufacturer.setLogoUrl(expected);

        //assert
        assertEquals(expected, manufacturer.getLogoUrl());
    }

    @Test
    void testToString() {
        //arrange
        String name = "testmanufacturer";
        Integer year = 1997;
        Boolean active = true;
        String expected = String.format("name: %s, founded in: %d, still active: %s", name, year, active);

        //act
        manufacturer.setName(name);
        manufacturer.setYearFounded(year);
        manufacturer.setActive(active);
        String resultaat = manufacturer.toString();

        //assert
        assertEquals(expected, resultaat);
    }
}