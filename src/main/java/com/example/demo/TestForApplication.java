package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestForApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(TestForApplication.class);

	public static void main(String[] args) {
		LOGGER.info("test log4j is working or not");
		SpringApplication.run(TestForApplication.class, args);
	}
}
