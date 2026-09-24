package com.arun.jobys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImplementor")
public class JobysApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobysApplication.class, args);
	}

}
