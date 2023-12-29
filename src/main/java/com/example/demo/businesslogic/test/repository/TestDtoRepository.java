package com.example.demo.businesslogic.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.businesslogic.test.domain.dto.TestDto;

public interface TestDtoRepository extends JpaRepository<TestDto, Long> {

}
