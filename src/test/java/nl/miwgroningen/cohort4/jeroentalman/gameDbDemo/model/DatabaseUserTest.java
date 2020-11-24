package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseUserTest {

    DatabaseUser databaseUser;

    @BeforeEach
    void setUp() {
        databaseUser = new DatabaseUser();
    }

    @Test
    void setUsername() {
       //arrange
        String expected = "testUser";
       databaseUser.setUsername(expected);

       //assert
        assertEquals(expected, databaseUser.getUsername(), "Error setting username");
    }

    @Test
    void getUsername() {
        //arrange
        String expected = null;
        String actual = databaseUser.getUsername();

        //assert
        assertEquals(expected, actual, "Error getting username");
    }

    @Test
    void setPassword() {
        //arrange
        String expected = "testPassword";
        databaseUser.setPassword(expected);

        //assert
        assertEquals(expected, databaseUser.getPassword(), "Error setting password");
    }

    @Test
    void getPassword() {
        //arrange
        String expected = null;
        String actual = databaseUser.getPassword();

        //asser
        assertEquals(expected, actual, "Error getting password");
    }
}