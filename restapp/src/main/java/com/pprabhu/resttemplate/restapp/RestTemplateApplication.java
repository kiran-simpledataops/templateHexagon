package com.pprabhu.resttemplate.restapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration

@ComponentScan(basePackages = {
		"com.pprabhu.resttemplate.*"

})
public class RestTemplateApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RestTemplateApplication.class, args);
		LOGGER.info("Starting app {}", ctx.getApplicationName());
		LOGGER.debug("found beans {}", ctx.getBeanDefinitionNames());
	}

}
