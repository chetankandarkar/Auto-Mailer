package com.auto.mailer.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping("/")
	public String test() {
		return "hello";
	}

// dummy cron
	@Scheduled(cron = "${auto.mailer.cron.time}")
	public void dummyCronJob() {
		System.out.println("THis will run every five minutes");
	}

//	dummy email service

	private void syso() {
		// TODO Auto-generated method stub

	}
	// dummy db call

//	dummy sheets api call

//	create and add in repo

//	dummy log 

}
