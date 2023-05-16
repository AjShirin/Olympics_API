package com.codeline.Olympics.Olympics_API.Controller;

import com.codeline.Olympics.Olympics_API.Service.ResultInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "results")
public class ResultInformationController {
    @Autowired
    ResultInformationService resultInformationService;

    @RequestMapping(value = "/createResultHistoryRecord", method = RequestMethod.POST)
    public String createResultHistoryRecord(@RequestParam String athlete, String country, String time, Integer eventId) {
        try {
            resultInformationService.createResultHistoryRecord(athlete, country, time, eventId);
        } catch (Exception e) {
            return "Failed... Please try again";
        }
        return "Result History has been Created Successfully :)";
    }
}
