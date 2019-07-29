/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import com.javatunes.persistence.ProductionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.ItemRepository;
import org.springframework.context.annotation.Profile;

@Configuration
// TODO: annotate this class for profile "prod"
@Profile("prod")
public class SpringProdRepositoryConfig {

	@Autowired
	private Integer maxSearchResults;
	
	@Bean
	ItemRepository itemRepository() {
		// TODO: Create an instance of the production repository
		// TODO: Set the max search results to maxSearchResults
		// TODO: Return the instance reference

		return new ProductionItemRepository();
	}

}