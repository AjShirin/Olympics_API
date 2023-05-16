package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import com.codeline.Olympics.Olympics_API.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}