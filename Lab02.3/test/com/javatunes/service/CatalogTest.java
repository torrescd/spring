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
	
	private void setupContext(AnnotationConfigApplicationContext ctx, String profile, Class<?> configClass ) {
		// TODO: Set the profile to the profile string given
		// TODO: Register the given Config classes
		// TODO: refresh the context
	}

	@Test
	public void testDevCatalogLookupPositive() {
		// Create context with no config classes
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// Setup for dev config 
		setupContext(ctx, "dev", SpringConfig.class);
		 // Look up the musicCatalog, assert it's not null, invoke toString  
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);
		assertNotNull("Dev Catalog should not be null", cat);
		System.out.println(cat.toString());
				
		ctx.close();
	}
	
	@Test
	public void testProdCatalogLookupPositive() {
		// Create context with no config classes
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// Setup for prod config 
		setupContext(ctx, "prod", SpringConfig.class);
		 // Look up the musicCatalog, assert it's not null, invoke toString  
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);
		assertNotNull("Prod Catalog should not be null", cat);
		System.out.println(cat.toString());
				
		ctx.close();
	}

	@Test
	public void testDevCatalogPositive() {
		String keyword = "a";
		// DONE: Create context, pass SpringConfig.class to the constructor
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// Setup for dev config 
		setupContext(ctx, "dev", SpringConfig.class);
		// Lookup catalog
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);

		// Call the size method test that it's greater than zero, and output its value
		long size = cat.size();
		assertTrue("Size should be greater than zero", size>0);
		System.out.println("Dev Catalog size is " + cat.size());
		
		// Call the findByKeyword method with "a", test that there is at least 
		// one item found, and output the found items
		Collection<MusicItem> results = cat.findByKeyword(keyword);
		assertTrue("Should find at least one item in findByKeyword(a)", results.size()>0);
		System.out.println("Dev Number of items found: " + results.size());
		System.out.println(results);

		// Close the context.
		ctx.close();
	}

	@Test
	public void testProdCatalogPositive() {
		String keyword = "a";
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// Setup for prod config 
		setupContext(ctx, "prod", SpringConfig.class);
		// Lookup catalog
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);

		// Call the size method test that it's greater than zero, and output its value
		long size = cat.size();
		assertTrue("Size should be greater than zero", size>0);
		System.out.println("{Prod Catalog size is " + cat.size());
		
		// Call the findByKeyword method with "a", test that there is at least 
		// one item found, and output the found items
		Collection<MusicItem> results = cat.findByKeyword(keyword);
		assertTrue("Should find at least one item in findByKeyword(a)", results.size()>0);
		System.out.println("Prod Number of items found: " + results.size());
		System.out.println(results);

		// Close the context.
		ctx.close();
	}
	
}
