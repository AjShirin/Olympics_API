package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Model.MedalStanding;
import com.codeline.Olympics.Olympics_API.Service.MedalStandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "standings")
public class MedalStandingController {

    @Autowired
    MedalStandingService medalStandingService;

    @RequestMapping(value = "/createMedalStandingRecord", method = RequestMethod.POST)
    public String createMedalStanding(@RequestParam String country, Integer goldMedal, Integer silverMedal, Integer bronzeMedal, Integer eventId) {
        try {
            medalStandingService.createMedalStandingRecord(country, goldMedal, silverMedal, bronzeMedal, eventId);
        } catch (Exception e) {
            return "Failed... Please try again";
        }
        return "Medal Standing has been Created Successfully :)";
    }

    // function to that gets the Medal data by Medal Standing Id (getStandingsByMedalStandingId)
    @RequestMapping(value = "/getStandingsByMedalStandingId", method = RequestMethod.GET)
    public MedalStanding getStandingsByMedalStandingId(@RequestParam Integer medalId) {
        MedalStanding medalStandingId = medalStandingService.getStandingsByMedalStandingId(medalId);
        return medalStandingId;
    }

    // function to that gets Medal data by Medal Standing country (getMedalStandingByCountry)
    @RequestMapping(value = "/getMedalStandingByCountry", method = RequestMethod.GET)
    public MedalStanding getMedalStandingByCountry(@RequestParam String country) {
        MedalStanding getMedalStandingByCountry = medalStandingService.getMedalStandingByCountry(country);
        return getMedalStandingByCountry;
    }

    // function to that gets all the Medal Standings (getAllMedalStandings)
    @RequestMapping(value = "/getAllMedalStandings", method = RequestMethod.GET)
    public List<MedalStanding> getAllMedalStandings() {
        List<MedalStanding> getAllMedalStandings = medalStandingService.getAllMedalStandings();
        return getAllMedalStandings;
    }
}
