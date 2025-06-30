package com.auto.mailer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final Logger logger = LogManager.getLogger(EmailService.class);

	@Autowired
	JavaMailSender javaMailSender;

	public void sendEmail(String fromAddress, String toAddress, String subject, String data) {
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

			simpleMailMessage.setFrom(fromAddress);
			simpleMailMessage.setTo(toAddress);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(data);

			javaMailSender.send(simpleMailMessage);
		} catch (Exception e) {
			logger.error("Error Occured");
		}

	}

}
