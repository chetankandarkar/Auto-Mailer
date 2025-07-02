package com.auto.mailer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auto.mailer.bean.AutoMailerBean;
import com.auto.mailer.service.AutoMailerService;
import com.auto.mailer.service.EmailService;

@RestController
public class Test {

	@Autowired
	AutoMailerService autoMailerService;

	@Autowired
	EmailService emailService;

	private static final Logger logger = LogManager.getLogger(Test.class);

	@GetMapping("/")
	public String test() {
		return "hello";
	}

	@GetMapping("/testMail")
	public String testMail() {
		emailService.sendEmail("md.ibrahim.khan98@gmail.com", "chetan.kandarkar99@gmail.com",
				"You Have Won 1 Crore Lottery ", "You Have Won 1 Crore Lottery");
		return "mail send";

	}

	@PostMapping("/start")
	public String doStuff(@RequestBody AutoMailerBean autoMailerBean) {
		autoMailerService.insertDataInDB(autoMailerBean);
		return "done";
	}

	@Scheduled(cron = "${auto.mailer.cron.time}")
	public void dummyCronJob() {
		logger.info("This will run every one minutes");
	}

//	dummy sheets api call

}
