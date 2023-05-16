package com.codeline.Olympics.Olympics_API.Service;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import com.codeline.Olympics.Olympics_API.Repository.AthleteRepository;
import com.codeline.Olympics.Olympics_API.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventService {
    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    EventRepository eventRepository;

    // function to create new Event (createEventRecord)
    public void createEventRecord(String eventName, String sport, String schedule, Integer numberOfAthletes, Integer athleteId) {
        AthleteInformation athleteInformation = athleteRepository.findById(athleteId).get(); // Find the athlete by the athleteId
        EventInformation event = new EventInformation(); // create new object
        event.setEventName(eventName);
        event.setSport(sport);
        event.setSchedule(schedule);
        event.setCreateDate(new Date()); // give current date
        event.setIsActive(Boolean.TRUE);
        event.setNumberOfAthletes(numberOfAthletes);
        event.setAthleteInformation(athleteInformation);
        eventRepository.save(event);
    }
    // function to that gets the event data by event Id (getEventByEventId)
    public EventInformation getEventByEventId(Integer id) {
        EventInformation eventInformationId = eventRepository.getEventByEventId(id);
        return eventInformationId;
    }
    // function to that gets the event data by event Name (getEventByEventName)
    public EventInformation getEventByEventName(String name) {
        EventInformation eventInformationName = eventRepository.getEventByEventName(name);
        return eventInformationName;
    }

}
