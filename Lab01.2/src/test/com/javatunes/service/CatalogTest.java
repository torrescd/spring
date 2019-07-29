/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CatalogTest {

	@Test
	public void testCatalogLookupPositive() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertTrue("spring container should not be null", ctx != null);
		Catalog catBean = ctx.getBean(Catalog.class);
		assertNotNull(catBean);

	}

	// TODO: Not until Dependency Injection Lab - annotate as test method
	public void testCatalogPositive() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertTrue("spring container should not be null", ctx != null);
		Catalog catBean = ctx.getBean(Catalog.class);
		assertNotNull(catBean);
	}

}
