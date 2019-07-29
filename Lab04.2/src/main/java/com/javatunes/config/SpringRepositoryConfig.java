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

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;

// DONE: Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {

	// DONE OPTIONAL
	@Autowired
	private Integer maxSearchResults;
	
	// DONE: Declare the item repository bean
	@Bean
	ItemRepository itemRepository() {
		InMemoryItemRepository repository = new InMemoryItemRepository();
		repository.setMaxSearchResults(maxSearchResults);
		return repository;
	}

}