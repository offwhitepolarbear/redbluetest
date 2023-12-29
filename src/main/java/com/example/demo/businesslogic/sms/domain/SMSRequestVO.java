package com.example.demo.businesslogic.sms.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SMSRequestVO {
	private String title ;
	private String content ;
	private String targetPhoneNumber ;

}
