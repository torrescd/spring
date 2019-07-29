/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;


import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Scope;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

// DONE: Declare as a configuration class
@Configuration
public class SpringServicesConfig {
	
	// DONE: Inject the repository
	@Autowired
	ItemRepository repository;

	// DONE: Declare the catalog bean definition
	@Bean
	Catalog catalog() {
		CatalogImpl cat = new CatalogImpl();
		cat.setItemRepository(repository);
		return cat;
	}

}