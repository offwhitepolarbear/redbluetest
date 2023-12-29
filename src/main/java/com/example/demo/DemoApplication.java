package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		String propertiesLocation = getPropertiesLocation();

		new SpringApplicationBuilder(DemoApplication.class).properties(propertiesLocation).run(args);
	}

	// 개발환경이랑 실제 서버 환경 프로퍼티 위치 확인용 메서드
	// FIXME 실행 레벨 PROD/LOCAL 분류해서 처리하면 더 좋을듯
	private static String getPropertiesLocation() {

		String propertiesLocation = null;

		final String windowPropertiesLocation = "spring.config.location="
				+ "C:\\sts-4.5.1.RELEASE\\yml\\DDSCrawling\\application.yml"
		// +","
		// +"classpath:/application.yml"
		;

		final String linuxPorpertiesLocation = "spring.config.location="
				+ "/home/ec2-user/app/00config/DDSCrawling/application.yml" + "," + "classpath:/application.yml";
		;

		String os = System.getProperty("os.name");

		if (os.contains("Windows")) {
			propertiesLocation = windowPropertiesLocation;
		}
		if (os.contains("Linux")) {
			propertiesLocation = linuxPorpertiesLocation;
		}

		return propertiesLocation;
	}
}
