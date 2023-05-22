package com.codeline.Olympics.Olympics_API.Service;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import com.codeline.Olympics.Olympics_API.Repository.AthleteRepository;
import com.codeline.Olympics.Olympics_API.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public List<AthleteInformation> getAllAthlete() {
        List<AthleteInformation> getAllAthlete = athleteRepository.getAllAthletes();
        return getAllAthlete;
    }

    // function that makes the isActive to false (deleteAthleteById)
    public void deleteAthleteById(Integer id) {
        AthleteInformation deleteAthleteById = athleteRepository.getAthleteByAthleteId(id);
        deleteAthleteById.setIsActive(Boolean.FALSE);
        athleteRepository.save(deleteAthleteById);

    }
    // function that updates Athlete records (updateAthlete)
    public String updateAthlete(Integer id, String name, Boolean isActive, String nationality, String athleteUpdatedDate) {
        try {
            AthleteInformation athlete = athleteRepository.getAthleteByAthleteId(id);
            athlete.setName(name);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date updatedDate = formatter.parse(athleteUpdatedDate);
            athlete.setUpdateDate(updatedDate);
            athlete.setIsActive(isActive);
            athlete.setNationality(nationality);
            athleteRepository.save(athlete);
            return "The Athlete ID:" + id + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }
}

