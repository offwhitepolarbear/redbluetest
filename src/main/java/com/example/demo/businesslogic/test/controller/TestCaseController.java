package com.example.demo.businesslogic.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businesslogic.test.service.TestCaseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestCaseController {

	private final TestCaseService testCaseService;
	
	
	@RequestMapping("/testOne")
	public void testCaseOne() {
		String testString = "testSTrubg141rr";
		int size = testCaseService.testCaseOne(testString);
		System.out.println(size);
	}

	
	public void testCaseTwo() {
		
	}

	
	public void testCaseThree() {
		
	}

	
	public void testCaseFour() {
		
	}

}
