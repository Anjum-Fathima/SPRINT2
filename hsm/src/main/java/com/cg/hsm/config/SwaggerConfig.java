package com.cg.hsm.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	
	@Bean
	public Docket productApi() {
		
		//Configure Swagger and return Docket instace
		return new Docket(DocumentationType.SWAGGER_2)		
				.select().apis(RequestHandlerSelectors.basePackage("com.cg.hsm.web"))
				.paths(PathSelectors.regex("/api.*"))				
				.build()
				.apiInfo(metoInfo());
	}

	private ApiInfo metoInfo() {
		// Customize the Swagger output
		ApiInfo apiInfo = new ApiInfo(
				"Health Service Management API", 
				"HSM API Created by < Capgemini >", 
				"1.0", 
				"Terms of Service", 
				new Contact("<Your name>", "Add your website url", "Add your email id"), 
				"<Your Company Name> Licence v.1.0", 
				"<Your Company URL>", new ArrayList<>());
		return apiInfo;
	}

}