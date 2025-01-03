package com.pbcompass.mscreditassessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCreditAssessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditAssessorApplication.class, args);
	}

}
