package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void getTitle() {
        //arrange
        String expected = null;
        String actual = game.getTitle();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting title");
    }

    @Test
    void setTitle() {
        //arrange
        String expected = "test";
        game.setTitle(expected);

        //no act

        //assert
        assertEquals(expected, game.getTitle(), "Error setting title");
    }

    @Test
    void getYear() {
        //arrange
        Integer expected = null;
        Integer actual = game.getYear();

        //no act

        //assert
        assertEquals(expected, actual, "Error getting year");
    }

    @Test
    void setYear() {
        //arrange
        Integer expected = 2020;
        game.setYear(2020);

        //no act

        //assert
        assertEquals(expected, game.getYear(), "Error setting year");
    }

    @Test
    void setYearInvalid() {
        try {
            game.setYear(1969);
            fail("er had een foutmelding gegooid moeten worden");
        } catch (IllegalArgumentException exception) {
            System.out.println("foutmelding succesvol afgevangen");
        } catch (Exception exception) {
            fail("Hier had een specifieke foutmelding moeten staan");
        }
    }

    @Test
    void getImageUrl() {
        //arrange
        String expected = null;
        String actual = game.getImageUrl();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setImageUrl() {
        //arrange
        String expected = "imageurl";
        game.setImageUrl(expected);

        //assert
        assertEquals(expected, game.getImageUrl());
    }

    @Test
    void getVideoUrl() {
        //arrange
        String expected = null;
        String actual = game.getVideoUrl();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setVideoUrl() {
        //arrange
        String expected = "videourl";
        game.setVideoUrl(expected);

        //assert
        assertEquals(expected, game.getVideoUrl());
    }

    @Test
    void testToString(){
        //arrange
        String title = "testgame";
        Integer year = 1997;
        String expected = String.format("%s, %d", title, year);

        //act
        game.setTitle(title);
        game.setYear(year);
        String resultaat = game.toString();

        //assert
        assertEquals(expected, resultaat);
    }
}