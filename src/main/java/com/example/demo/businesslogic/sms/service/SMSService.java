package com.example.demo.businesslogic.sms.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.businesslogic.sms.domain.SMSRequestVO;
import com.example.demo.businesslogic.sms.domain.SMSResponseVO;

@Service
public class SMSService {
	
	public ResponseEntity<Object> sendMessage(SMSRequestVO smsRequest) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add("content-disposition", "attachment; filename=" + fileName);
        responseHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		SMSResponseVO smsResponse = SMSResponseVO.builder().message("Successfully sent").build();
        return new ResponseEntity(smsResponse, responseHeaders, HttpStatus.OK);
	}
}
