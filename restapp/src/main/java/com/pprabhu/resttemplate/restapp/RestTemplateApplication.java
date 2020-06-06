package com.pprabhu.resttemplate.restapp;

import com.pprabhu.resttemplate.api.MessageService;
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


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RestTemplateApplication.class, args);
		System.out.println("Main method");
		System.out.println("impls=" + ctx.getBean(MessageService.class));
	}


}
