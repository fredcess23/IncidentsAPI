package com.maranatha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = "com.maranatha") 
public class ApplicationConfiguration{

	@Bean
    public Docket navigationPages() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Incident API")
                .apiInfo(apiInfo())
                .select()
                //.paths(regex("/navigation/pages.*"))
            	.paths(PathSelectors.any())      
            	.build();
    }
	
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Incidents REST API Documentation")
                .description("Shows a list of services which give data about common dangerous places in cities")
                .termsOfServiceUrl("")
                .contact("Cesar Cruz")
                .license("Apache License Version 2.0")
                .licenseUrl("")
                .version("1.0")
                .build();
    }
	
	
}
