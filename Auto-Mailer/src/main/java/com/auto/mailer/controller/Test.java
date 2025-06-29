package com.auto.mailer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auto.mailer.bean.AutoMailerBean;
import com.auto.mailer.service.AutoMailerService;

@RestController
public class Test {

	@Autowired
	AutoMailerService autoMailerService;

	@GetMapping("/")
	public String test() {
		return "hello";

	}

	@PostMapping("/start")
	public String doStuff(@RequestBody AutoMailerBean autoMailerBean) {
		autoMailerService.insertDataInDB(autoMailerBean);

		return "done";
	}

	// dummy cron
	@Scheduled(cron = "${auto.mailer.cron.time}")
	public void dummyCronJob() {
		System.out.println("THis will run every five minutes");
	}

//	dummy email service

//	dummy sheets api call

}
