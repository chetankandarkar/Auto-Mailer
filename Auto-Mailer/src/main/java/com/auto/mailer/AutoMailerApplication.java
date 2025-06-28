package com.auto.mailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoMailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoMailerApplication.class, args);
	}

}
