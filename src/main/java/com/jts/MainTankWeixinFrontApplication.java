package com.jts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MainTankWeixinFrontApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainTankWeixinFrontApplication.class, args);
	}
}
