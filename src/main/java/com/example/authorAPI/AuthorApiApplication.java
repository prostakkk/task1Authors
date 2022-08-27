package com.example.authorAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Authors API",
				version = "1.6.11",
				description = "Authors Information")
)
public class AuthorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorApiApplication.class, args);
	}



}
