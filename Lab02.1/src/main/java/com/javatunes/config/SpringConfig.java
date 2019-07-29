/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// TODO: Declare as a Spring configuration class
// TODO: Add component scan for com.javatunes
// TODO: Import other config classes
@Configuration
@ComponentScan(basePackages = "com.javatunes.config")
//@Import({SpringDomainConfig.class, SpringRepositoryConfig.class, SpringServicesConfig.class})
public class SpringConfig {}