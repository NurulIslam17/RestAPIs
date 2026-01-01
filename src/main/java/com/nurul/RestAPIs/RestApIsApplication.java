package com.nurul.RestAPIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApIsApplication.class, args);
	}

}
