/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Declare as a Spring configuration class
@Configuration
public class SpringDomainConfig {

	// Declare as a bean definition
	@Bean
	public Integer maxSearchResults () {
		return Math.max(1, (int) (Math.random()*10));
	}
	
}