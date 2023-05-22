package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import com.codeline.Olympics.Olympics_API.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "events")
public class EventController {
    @Autowired
    EventService eventService;


    @RequestMapping(value = "/createEventRecord", method = RequestMethod.POST)
    public String createEventRecord(@RequestParam String eventName, String sport, String schedule, Integer numberOfAthletes, Integer athleteId) {
        try {
            eventService.createEventRecord(eventName, sport, schedule, numberOfAthletes, athleteId);
        } catch (Exception e) {
            return "Failed... Please try again";
        }
        return "Event Created Successfully :)";
    }

    //function that gets event By name (getEventByEventName)
    @RequestMapping(value = "/getEventByEventName", method = RequestMethod.GET)
    public EventInformation getEventByEventName(@RequestParam String name) {
        EventInformation eventName = eventService.getEventByEventName(name);
        return eventName;
    }

    // function to that gets all the Events data(getAllEvents)
    @RequestMapping(value = "/getAllEvents", method = RequestMethod.GET)
    public List<EventInformation> getAllEvents() {
        List<EventInformation> getAllEvents = eventService.getAllEvents();
        return getAllEvents;
    }

    // function to that gets the event data by event Id (getEventByEventId)
    @RequestMapping(value = "/getEventByEventId", method = RequestMethod.GET)
    public EventInformation getEventByEventId(@RequestParam Integer eventId) {
        EventInformation eventInformationId = eventService.getEventByEventId(eventId);
        return eventInformationId;
    }

    // function that changes that isActive to false (deleteEventById)
    @RequestMapping(value = "/deleteEventById", method = RequestMethod.POST)
    public String deleteEventById(@RequestParam Integer id) {
        try {
            eventService.deleteEventById(id);
        } catch (Exception e) {
            return "Event Failed to deactivate please try again";
        }
        return "Event Deleted Successfully :)";

    }

    // This function Updates a record for Event  with user Input (updateEvent)
    @RequestMapping(value = "/updateEvent", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEvent(@RequestParam Integer id, Boolean isActive, String sport, String eventUpdatedDate) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = eventService.updateEvent(id, isActive, sport, eventUpdatedDate);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Event is not updated. Please try again.");
        }
    }

}
