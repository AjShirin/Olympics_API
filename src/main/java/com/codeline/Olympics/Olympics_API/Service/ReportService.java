package com.codeline.Olympics.Olympics_API.Service;

import com.codeline.Olympics.Olympics_API.DTO.AthleteOlympicsDTO;
import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import com.codeline.Olympics.Olympics_API.Repository.AthleteRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    public static final String pathToReports = "C:\\Users\\user020\\Documents\\Olympics_API\\Olympics_API\\reports";


    public String generateAthleteReport() throws FileNotFoundException, JRException {
        List<AthleteInformation> athleteInformationLists = athleteRepository.getAllAthletes();
        List<AthleteOlympicsDTO> AthleteDTOList = new ArrayList<>();
        for (AthleteInformation athleteListVariable : athleteInformationLists) {
            String athleteName = athleteListVariable.getName();
            Boolean athleteActivationStatus = athleteListVariable.getIsActive();
            AthleteOlympicsDTO performanceOfTheOlympicsDTO = new AthleteOlympicsDTO(athleteName, athleteActivationStatus);
            AthleteDTOList.add(performanceOfTheOlympicsDTO);
        }

        File file = new File("C:\\Users\\user020\\Documents\\Olympics_API\\Olympics_API\\src\\main\\resources\\AthleteOlympicsReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(AthleteDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AthleteOlympicsReport.pdf");
        return "Report generated : " + pathToReports + "\\AthleteOlympicsReport.pdf";
    }
}

