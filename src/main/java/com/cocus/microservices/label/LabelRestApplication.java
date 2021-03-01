package com.cocus.microservices.label;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.cocus.microservices.bo", "com.cocus.microservices.label"})
@EnableJpaRepositories(value = {"com.cocus.microservices.label.repositories"})
public class LabelRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabelRestApplication.class, args);
	}

}
