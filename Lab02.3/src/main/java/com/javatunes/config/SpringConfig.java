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
import org.springframework.context.annotation.Import;



@Configuration // Declare as a Spring configuration class
@ComponentScan(basePackages = "com.javatunes") // Add component scan for com.javatunes
//Import other config classes (both of the repository config types)
@Import({SpringDevRepositoryConfig.class, SpringProdRepositoryConfig.class, SpringServicesConfig.class, SpringDomainConfig.class})
public class SpringConfig {}