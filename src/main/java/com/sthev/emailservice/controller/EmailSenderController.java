package com.sthev.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sthev.emailservice.application.EmailSenderService;
import com.sthev.emailservice.core.EmailRequest;
import com.sthev.emailservice.core.exception.EmailServiceException;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
	
	private final EmailSenderService emailSenderService;
	
	@Autowired
	public EmailSenderController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}
	
	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
		try {
			this.emailSenderService.senderEmail(request.to(), request.subject(), request.body());
			return ResponseEntity.ok("Email send successfully");
		}catch(EmailServiceException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erros while sending email");
		}
	}

}
