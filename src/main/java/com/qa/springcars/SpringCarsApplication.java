package com.qa.springcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCarsApplication {

	public static void main(String[] args) {
		// Create ApplicationContext - Bean Bag!
//		ApplicationContext beanbag = SpringApplication.run(SpringCarsApplication.class, args);
//		
//		System.out.println(beanbag.containsBean("greeting"));
//		System.out.println(beanbag.containsBean("clock"));
//		
//		System.out.println(beanbag.getBean("clock"));
		
		SpringApplication.run(SpringCarsApplication.class, args);
		
	}
	
	// Beans are MANAGED OBJECTS ->
	// Spring with CREATE, MAINTAIN and DESTROY these Objects for us!
	
//	@Bean
//	public String greeting() {
//		return "Cameron says hello";
//	}
//	
//	@Bean
//	public LocalTime clock() {
//		return LocalTime.now();
//	}

}
