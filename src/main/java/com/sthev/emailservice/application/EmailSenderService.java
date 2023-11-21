package com.sthev.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.sthev.emailservice.adapters.EmailSenderGateway;
import com.sthev.emailservice.core.EmailSenderUseCase;

public class EmailSenderService implements EmailSenderUseCase{

	private final EmailSenderGateway emailSenderGateway;
	
	@Autowired
	public EmailSenderService (EmailSenderGateway emailGateway) {
		this.emailSenderGateway = emailGateway;
	}
	
	@Override
	public void senderEmail(String to, String subject, String body) {
		this.emailSenderGateway.senderEmail(to, subject, body);
	}
	
}
