/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {

	// TODO: Declare the item repository bean
    @Bean
    public ItemRepository itemRepo(){
        return new InMemoryItemRepository();
    }
}