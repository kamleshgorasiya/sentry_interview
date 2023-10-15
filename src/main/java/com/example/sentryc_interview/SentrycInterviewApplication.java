package com.example.sentryc_interview;

import com.example.sentryc_interview.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentrycInterviewApplication implements CommandLineRunner {

	@Autowired
	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(SentrycInterviewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataService.generateAndSaveData();
	}
}
