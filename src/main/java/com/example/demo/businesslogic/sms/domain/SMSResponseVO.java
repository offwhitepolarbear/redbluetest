package com.example.demo.businesslogic.sms.domain;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Builder;
import lombok.Getter;

@ResponseBody
@Getter
public class SMSResponseVO {
	private final String message;
	
	@Builder
	public SMSResponseVO(String message){
		this.message = message;
	}
}
