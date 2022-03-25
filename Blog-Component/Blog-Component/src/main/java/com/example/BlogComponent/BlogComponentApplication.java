package com.example.BlogComponent;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class BlogComponentApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogComponentApplication.class, args);

	}
}
