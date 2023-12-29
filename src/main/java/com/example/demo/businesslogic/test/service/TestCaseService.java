package com.example.demo.businesslogic.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.businesslogic.test.domain.dto.TestDto;
import com.example.demo.businesslogic.test.repository.TestDtoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestCaseService {
	
	private final TestDtoRepository testDtoRepository;
	
	//HashMap을 이용 String 의 글자수 카운트하는 메서드를 직접 작성	
	public int testCaseOne(String testString) {
		int result = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] stringSplit = testString.split("");
		for (String eachString : stringSplit) {
			if (map.containsKey(eachString)){
				int count = map.get(eachString);
				map.put(eachString,count+1);
			}
			else {
				map.put(eachString, 1);
			}
		}
		
		List<Integer> resultList = new ArrayList<Integer>(map.values());
		for (int i : resultList) {
			result += i;
		}
		return result;
	}

	// json으로 전달받ㄴ은 입력값을 500건마다 bulk insert 하는 프로그램
	public void testCaseTwo(List<TestDto> jsonList) {
		
		// 500개 이상인 경우
		if(jsonList.size()>500) {
			List<List<TestDto>> jsonSplitList = splitList(jsonList);
			for (List<TestDto> eachJsonGroupList: jsonSplitList) {
				saveJsonList(eachJsonGroupList);
			}
		}
		else {
			saveJsonList(jsonList);
		}
		
		
	}
	
	// 500개씩 리스트로 분리해서 담기
	private List<List<TestDto>> splitList(List<TestDto> jsonList){
		List<List<TestDto>> result = new ArrayList<List<TestDto>>();
		
		int eachGroupSize = 500;
		int predictResultSize = jsonList.size()/eachGroupSize;
		if (jsonList.size()%eachGroupSize>0) {
			predictResultSize += 1;
		}
		
		while(result.size()>=predictResultSize) {
			int startIndex = 0;
			if (startIndex+eachGroupSize <= jsonList.size()) {
				List<TestDto> eachGroup = jsonList.subList(startIndex, eachGroupSize);
				result.add(eachGroup);
			}
			else {
				result.add(jsonList);
			}
		}
		
		return result;
	}
	
	private void saveJsonList(List<TestDto> jsonList) {
		testDtoRepository.saveAll(jsonList);
	}
}
