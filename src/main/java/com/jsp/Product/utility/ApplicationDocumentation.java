package com.jsp.Product.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDocumentation {

//	url: localhost:8080/swagger-ui.html
	
	Info info() {
		return new Info().title("Product Management System")
						 .description("Basic crud operations")
						 .version("v1")
						 .contact(contact());
	}
	
	Contact contact() {
		return new Contact().name("Bindu Sirigere RajaShekar")
							.email("binduakka@gmail.com")
							.url("bindu.in");
	}
	 
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
	
}
