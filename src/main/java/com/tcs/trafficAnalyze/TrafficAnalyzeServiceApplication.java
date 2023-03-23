package com.tcs.trafficAnalyze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrafficAnalyzeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficAnalyzeServiceApplication.class, args);
	}

}
