package com.qa.springcars;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarsApplication {

	public static void main(String[] args) {
		// Create ApplicationContext - Bean Bag!
		ApplicationContext beanbag = SpringApplication.run(CarsApplication.class, args);
		
		System.out.println(beanbag.containsBean("greeting"));
		System.out.println(beanbag.containsBean("clock"));
		
		System.out.println(beanbag.getBean("clock"));
		
	}
	
	// Beans are MANAGED OBJECTS ->
	// Spring with CREATE, MAINTAIN and DESTROY these Objects for us!
	
	@Bean
	public String greeting() {
		return "Cameron says hello";
	}
	
	@Bean
	public LocalTime clock() {
		return LocalTime.now();
	}

}
