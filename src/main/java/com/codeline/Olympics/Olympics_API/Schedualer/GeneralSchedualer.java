package com.codeline.Olympics.Olympics_API.Schedualer;

import com.codeline.Olympics.Olympics_API.Service.MedalStandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;

public class GeneralSchedualer {
    @Autowired
    MedalStandingService medalStandingService;

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Scheduled(cron = "0 0/5 * * * *") // Runs every 5 minutes
    public void sendEmail() {
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo("shirinajmi@gmail.com");
            mailMessage.setText("Medal Standing Updates are :");
            mailMessage.setSubject("Olympics ");
            // Sending the mail
            javaMailSender.send(mailMessage);

        } catch (Exception e) {
            // Catch block to handle the exceptions
            e.printStackTrace();

        }
    }

}