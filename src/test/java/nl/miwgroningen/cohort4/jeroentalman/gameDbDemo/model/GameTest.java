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
    void testToString(){
        //arrange
        String title = "testgame";
        Integer year = 1997;
        String expected = String.format("%s, %d", title, year);

        game.setTitle(title);
        game.setYear(year);
        String resultaat = game.toString();

        assertEquals(expected, resultaat);
    }
}