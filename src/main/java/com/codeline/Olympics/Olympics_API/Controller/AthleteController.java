package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import com.codeline.Olympics.Olympics_API.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "athlete")
public class AthleteController {
    @Autowired
    AthleteService athleteService;

    @RequestMapping(value = "/createAthleteRecord", method = RequestMethod.POST)
    public String createAthleteRecord(@RequestParam String name, String nationality, String sport) {
        try {
            athleteService.createAthleteRecord(name, nationality, sport);
        } catch (Exception e) {
            return "Failed... Please try again :(";
        }
        return "Athlete Record Created Successfully :)";
    }

    //function that gets athlete By ID (getAthleteByAthleteId)
    @RequestMapping(value = "/getAthleteByAthleteId", method = RequestMethod.GET)
    public AthleteInformation getAthleteByAthleteId(@RequestParam Integer athleteId) {
        AthleteInformation athleteInformation = athleteService.getAthleteByAthleteId(athleteId);
        return athleteInformation;
    }

    // function to that gets the athlete data by athlete Name (getAthleteByAthleteName)
    @RequestMapping(value = "/getAthleteByAthleteName", method = RequestMethod.GET)
    public AthleteInformation getAthleteByAthleteName(@RequestParam String athleteName) {
        AthleteInformation athleteByName = athleteService.getAthleteByAthleteName(athleteName);
        return athleteByName;
    }

    // function to that gets all the athlete data(getAllAthlete)
    @RequestMapping(value = "/getAllAthletes", method = RequestMethod.GET)
    public List<AthleteInformation> getAllAthletes() {
        List<AthleteInformation> getAllAthletes = athleteService.getAllAthlete();
        return getAllAthletes;
    }

    // function that changes that isActive to false (deleteAthleteById)
    @RequestMapping(value = "/deleteAthleteById", method = RequestMethod.POST)
    public String deleteAthleteById(@RequestParam Integer id) {
        try {
            athleteService.deleteAthleteById(id);
        } catch (Exception e) {
            return "Athlete Record Failed to deactivate please try again";
        }
        return "Athlete Record Deleted Successfully :)";

    }
    // This function Updates a record for Athlete  with user Input (updateAthlete)
    @RequestMapping(value = "/updateAthlete", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAthlete(@RequestParam Integer id, String name, Boolean isActive, String nationality, String athleteUpdatedDate) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = athleteService.updateAthlete( id,  name,  isActive,  nationality,  athleteUpdatedDate);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Athlete is not updated. Please try again.");
        }
    }

}

