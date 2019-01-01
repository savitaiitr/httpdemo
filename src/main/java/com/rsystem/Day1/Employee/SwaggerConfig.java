package com.rsystem.Day1.Employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public static final Contact DEFAULT_CONTACT = new Contact("Ankur Jain", "rsystems,com", "ankur.jain@rsystems.com");
	  public static final ApiInfo DEFAULT_ApiInfo = new ApiInfo("Employee Documentation", "Employee Information", "1.0", "TERMSand CON",
	          DEFAULT_CONTACT, "License", "google.com");
	  Set<String> produces = new HashSet<>(Arrays.asList("applicatin/json", "applicatin/xml"));
	@Bean
	public Docket api() {
		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_ApiInfo)
				.produces(produces)
				.consumes(produces)
				;
	}

}
