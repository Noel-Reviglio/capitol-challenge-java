package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.framework.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.spring.skeleton.infrastructure")
@EntityScan(basePackages = "com.spring.skeleton.domain")
public class NoelReviglioApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoelReviglioApplication.class, args);
	}

}
