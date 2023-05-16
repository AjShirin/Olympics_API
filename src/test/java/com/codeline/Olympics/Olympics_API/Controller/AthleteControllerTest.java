package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AthleteControllerTest {

    @Autowired
    AthleteController athleteController;

    @Test
    void getAthleteByAthleteName() {
        AthleteInformation getAthleteByNameTest = athleteController.getAthleteByAthleteName("Simon Biles");
        String nationality = getAthleteByNameTest.getNationality();
        assertNotNull(getAthleteByNameTest); // Make sure that the getAthleteByNameTest object is not null. If it is null, the test will fail.
        assertEquals("USA", nationality); // the assertion will check the expected given nationality from database. If it is not equal then it will fail.
        assertNotEquals("OMAN", nationality); // the assertion will check the Not expected given nationality from database. If it is not in the database then it will success.
    }

    @Test
    void getAthleteByAthleteId() {
        String getAthleteByAthleteIdWithAthleteNameTest = athleteController.getAthleteByAthleteId(3).getName();
        assertEquals("Xaviar Herry", getAthleteByAthleteIdWithAthleteNameTest);
        assertNotEquals("Shirin", getAthleteByAthleteIdWithAthleteNameTest);
    }
}