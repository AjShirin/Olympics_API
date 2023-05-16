package com.codeline.Olympics.Olympics_API.Service;

import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import com.codeline.Olympics.Olympics_API.Model.MedalStanding;
import com.codeline.Olympics.Olympics_API.Repository.EventRepository;
import com.codeline.Olympics.Olympics_API.Repository.MedalStandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedalStandingService {
    @Autowired
    MedalStandingRepository medalStandingRepository;
    @Autowired
    EventRepository eventRepository;


    // function to create new medal standing (createMedalStanding)
    public void createMedalStandingRecord(String country, Integer goldMedal, Integer silverMedal, Integer bronzeMedal, Integer eventId) {
        EventInformation eventInformation = eventRepository.findById(eventId).get(); // Find the event by the eventId
        MedalStanding medalStanding = new MedalStanding(); // create new object
        medalStanding.setCountry(country);
        medalStanding.setGoldMedal(goldMedal);
        medalStanding.setSilverMedal(silverMedal);
        medalStanding.setBronzeMedal(bronzeMedal);
        medalStanding.setCreateDate(new Date());// give current date
        medalStanding.setIsActive(Boolean.TRUE);
        medalStanding.setEventInformation(eventInformation);
        medalStandingRepository.save(medalStanding); // Save the MedalStanding
    }
    // function to that gets the Medal data by Medal Standing Id (getStandingsByMedalStandingId)
    public MedalStanding getStandingsByMedalStandingId(Integer id) {
        MedalStanding medalStanding = medalStandingRepository.getStandingsByMedalId(id);
        return medalStanding;
    }
    // function to that gets Medal data by Medal Standing country (getMedalStandingByCountry)
    public MedalStanding getMedalStandingByCountry(String country) {
        MedalStanding medalStandingCountry = medalStandingRepository.getMedalStandingByCountry(country);
        return medalStandingCountry;
    }
    // function to that gets all the Medal Standings (getAllMedalStandings)
    public List<MedalStanding> getAllMedalStandings() {
        List<MedalStanding> getAllMedalStandings = medalStandingRepository.getAllStandings();
        return getAllMedalStandings;
    }



}
