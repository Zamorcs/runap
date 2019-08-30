package com.bindot.runap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.bindot.runap.model")
public class RunapApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunapApplication.class, args);
	}

}

