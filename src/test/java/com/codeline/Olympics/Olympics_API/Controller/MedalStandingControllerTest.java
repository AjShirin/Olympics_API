package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import com.codeline.Olympics.Olympics_API.Model.MedalStanding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MedalStandingControllerTest {

    @Autowired
    MedalStandingController medalStandingController;

    @Test
    void getStandingsByMedalStandingId() {
        Integer getStandingsByMedalStandingIdWithBronzeMedalTest = medalStandingController.getStandingsByMedalStandingId(3).getBronzeMedal();
        assertEquals(96, getStandingsByMedalStandingIdWithBronzeMedalTest);
        assertNotEquals(55, getStandingsByMedalStandingIdWithBronzeMedalTest);
    }

    @Test
    void getMedalStandingByCountry() {
        MedalStanding getMedalStandingByCountryTest = medalStandingController.getMedalStandingByCountry("Canada");
        Integer goldMedal = getMedalStandingByCountryTest.getGoldMedal();
        assertNotNull(getMedalStandingByCountryTest);
        assertEquals(58, goldMedal);
        assertNotEquals(32, goldMedal);
    }
}