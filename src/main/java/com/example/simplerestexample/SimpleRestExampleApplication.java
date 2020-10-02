package com.example.simplerestexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication


public class SimpleRestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestExampleApplication.class, args);
	}

}
