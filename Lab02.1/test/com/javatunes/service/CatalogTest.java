/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;

public class CatalogTest {

	@Test
	public void testCatalogLookupPositive() {
		// TODO: Create context, pass SpringConfig.class to the constructor
		AnnotationConfigApplicationContext ctx = null;
		assertNotNull("spring container should not be null", ctx);

		// Look up the musicCatalog, assert it's not null, invoke toString  
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);
		assertNotNull("Catalog should not be null", cat);
		System.out.println(cat.toString());
				
		ctx.close();
	}

	// Annotate as test method
	@Test
	public void testCatalogPositive() {
		String keyword = "a";
		// TODO: Create context, pass SpringConfig.class to the constructor
		AnnotationConfigApplicationContext ctx = null;
		// Lookup catalog
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);

		// Call the size method test that it's greater than zero, and output its value
		long size = cat.size();
		assertTrue("Size should be greater than zero", size>0);
		System.out.println("Catalog size is " + cat.size());
		
		// Call the findByKeyword method with "a", test that there is at least 
		// one item found, and output the found items
		Collection<MusicItem> results = cat.findByKeyword(keyword);
		assertTrue("Should find at least one item in findByKeyword(a)", results.size()>0);
		System.out.println("Number of items found: " + results.size());
		System.out.println(results);

		// Close the context.
		ctx.close();
	}


}
