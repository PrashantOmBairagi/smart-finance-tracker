package com.prashant.smartfinancetracker;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SmartFinanceTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartFinanceTrackerAppApplication.class, args);

	}
	@PostConstruct
	public void set() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

}
