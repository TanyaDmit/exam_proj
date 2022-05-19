package com.fintech.examproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamprojApplication.class, args);
	}

}
