/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

// Declare as a configuration class
@Configuration
public class SpringServicesConfig {
	
	// Inject the repository
	@Autowired
	ItemRepository repository;

	// Declare the catalog bean definition
	@Bean
// DONE: Change scope to prototype	
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	Catalog catalog() {
		CatalogImpl cat = new CatalogImpl();
		cat.setItemRepository(repository);
		return cat;
	}

}