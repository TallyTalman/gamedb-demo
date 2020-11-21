package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublisherTest {

    Publisher publisher;

    @BeforeEach
    void setUp() {
        publisher= new Publisher();
    }

    @Test
    void getName() {
        //arrange
        String expected = null;
        String actual = publisher.getName();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting name");
    }

    @Test
    void setName() {
        //arrange
        String expected = "test";
        publisher.setName(expected);

        //no act

        //assert
        assertEquals(expected, publisher.getName(), "Error setting name");
    }

    @Test
    void getYearFounded() {
        //arrange
        Integer expected = null;
        Integer actual = publisher.getYearFounded();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting year founded");
    }

    @Test
    void setYearFounded() {
        //arrange
        Integer expected = 2020;
        publisher.setYearFounded(expected);

        //no act

        //assert
        assertEquals(expected, publisher.getYearFounded(), "Error setting year founded");
    }

    @Test
    void setYearFoundedInvalid() {
        try {
            publisher.setYearFounded(1879);
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
        Boolean actual = publisher.getActive();

        //no act

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setActive() {
        //arrange
        Boolean expected = true;
        publisher.setActive(expected);

        //assert
        assertEquals(expected, publisher.getActive());
    }

    @Test
    void getLogoUrl() {
        //arrange
        String expected = null;
        String actual = publisher.getLogoUrl();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setLogoUrl() {
        //arrange
        String expected = "testurl";
        publisher.setLogoUrl(expected);

        //assert
        assertEquals(expected, publisher.getLogoUrl());
    }

    @Test
    void testToString() {
        //arrange
        String name = "testpublisher";
        Integer year = 1997;
        Boolean active = true;
        String expected = String.format("name: %s, founded in: %d, still active: %s", name, year, active);

        //act
        publisher.setName(name);
        publisher.setYearFounded(year);
        publisher.setActive(active);
        String resultaat = publisher.toString();

        //assert
        assertEquals(expected, resultaat);
    }
}