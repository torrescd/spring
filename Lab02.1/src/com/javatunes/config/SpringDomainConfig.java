/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

// TODO: Declare as a Spring configuration class
public class SpringDomainConfig {

	// TODO: Declare as a bean definition
	public Integer maxSearchResults () {
		return Math.max(1, (int) (Math.random()*10));
	}
	
}