package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {

    Genre genre;

    @BeforeEach
    void setUp() {
        genre = new Genre();
    }

    @Test
    void getType() {
        //arrange
        String expected = null;
        String actual = genre.getType();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setType() {
        //arrange
        String expected = "test";
        genre.setType(expected);

        //assert
        assertEquals(expected, genre.getType());
    }

    @Test
    void testToString() {
        //arrange
        String type = "test";
        String expected = String.format("genre: %s", type);

        //act
        genre.setType(type);

        //assert
        assertEquals(expected, genre.toString());
    }
}