package com.codeline.Olympics.Olympics_API.Service;

import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import com.codeline.Olympics.Olympics_API.Model.ResultInformation;
import com.codeline.Olympics.Olympics_API.Repository.EventRepository;
import com.codeline.Olympics.Olympics_API.Repository.ResultInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultInformationService {
    @Autowired
    ResultInformationRepository resultInformationRepository;
    @Autowired
    EventRepository eventRepository;

    public void createResultHistoryRecord(String athlete, String country, String time, Integer eventId) {
        EventInformation eventInformation = eventRepository.findById(eventId).get(); // Find the event by the eventId
        ResultInformation resultInformation = new ResultInformation();
        resultInformation.setAthlete(athlete);
        resultInformation.setCountry(country);
        resultInformation.setTime(time);
        resultInformation.setEventInformation(eventInformation);
        resultInformationRepository.save(resultInformation); // Save the ResultInformation
    }
}
