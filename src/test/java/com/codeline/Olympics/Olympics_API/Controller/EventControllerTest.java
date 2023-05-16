package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventControllerTest {

    @Autowired
    EventController eventController;

    @Test
    void getEventByEventName() {
        EventInformation getEventByEventNameTest = eventController.getEventByEventName("Jumping Jacks Falls");
        String sport = getEventByEventNameTest.getSport();
        assertNotNull(getEventByEventNameTest);
        assertEquals("Jump", sport);
        assertNotEquals("Crawl", sport);
    }

    @Test
    void getEventByEventId() {
        String getEventByEventIdWithEventNameTest = eventController.getEventByEventId(4).getEventName();
        assertEquals("Falling Apart", getEventByEventIdWithEventNameTest);
        assertNotEquals("Xamiar", getEventByEventIdWithEventNameTest);
    }
}