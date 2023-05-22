package com.codeline.Olympics.Olympics_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication // use to annotate the main class of a Spring Boot application.
@EnableWebSecurity // used to enable Spring Security in a web application.
@EnableScheduling //enable scheduling
@EnableGlobalMethodSecurity(prePostEnabled = true) // enable security for pre-authorized and post-authorized
public class OlympicsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlympicsApiApplication.class, args);
	}

}
