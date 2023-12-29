package com.example.demo.businesslogic.test.domain.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestDto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

}
