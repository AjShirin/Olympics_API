package com.codeline.Olympics.Olympics_API.Service;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import com.codeline.Olympics.Olympics_API.Repository.AthleteRepository;
import com.codeline.Olympics.Olympics_API.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AthleteService {
    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    EventRepository eventRepository;


    // function to create new athlete (createAthleteRecord)
    public void createAthleteRecord(String name, String nationality, String sport) {
        AthleteInformation athlete = new AthleteInformation(); // create object to save everything
        athlete.setName(name);
        athlete.setNationality(nationality);
        athlete.setSport(sport);
        athlete.setIsActive(Boolean.TRUE);
        athlete.setCreateDate(new Date());
        athleteRepository.save(athlete);
    }

    // function to that gets the athlete data by athlete Id (getAthleteByAthleteId)
    public AthleteInformation getAthleteByAthleteId(Integer id) {
        AthleteInformation athleteInformationId = athleteRepository.getAthleteByAthleteId(id);
        return athleteInformationId;
    }
    // function to that gets the athlete data by athlete Name (getAthleteByAthleteName)
    public AthleteInformation getAthleteByAthleteName(String name) {
        AthleteInformation athleteInformationName = athleteRepository.getAthleteByAthleteName(name);
        return athleteInformationName;
    }
    // function to that gets all the athlete data(getAllAthlete)
    public AthleteInformation getAllAthlete() {
        AthleteInformation getAllAthlete = athleteRepository.getAllAthletes();
        return getAllAthlete;
    }

}

