package com.example.demo.businesslogic.sms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businesslogic.sms.domain.SMSRequestVO;
import com.example.demo.businesslogic.sms.domain.SMSResponseVO;
import com.example.demo.businesslogic.sms.service.SMSService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SMSController {
	
	private final SMSService smsService;
	
	@PostMapping("/api/sendSMS")
	public ResponseEntity<Object> testCaseFour(@RequestBody SMSRequestVO smsRequest) {
		return smsService.sendMessage(smsRequest);
	}
}
