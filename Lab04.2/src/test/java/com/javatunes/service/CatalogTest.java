/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;


import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// TODO: Run the tests with the special Spring runner
// TODO: Read SpringConfig.class to initialize the context and initialize Spring Boot
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CatalogTest {

    @Autowired
    Catalog cat;
    
	@Test
	public void test1_testCatalogFindByIdPositive() {
		
		System.out.println("\n*** Retrieving item from the database ***");
		System.out.println(cat.findById(1L));  // I would have them add this line
		System.out.println("***\n");
	}

	@Test
	// TODO: 2nd part of lab - Fix the problem with this method.
    public void test2_testDeletePositive() {
		System.out.println("\n*** Testing delete ***");
    		long oldSize = cat.size();
    		MusicItem toRemove = new MusicItem(2L);
    		cat.remove(toRemove);
    		long newSize = cat.size();
    		System.out.println("***\n");
    		assertTrue ("Delete should reduce size by one\n", newSize == oldSize-1);
    }

    @Test
    public void test3_testSizePositive() {
		System.out.println("\n*** Testing size ***");
    		long expectedSize = 18L;
    		long currentSize = cat.size();
    		System.out.format("Current size is %s\n", currentSize);
    		System.out.println("***\n");
    		assertTrue("Size should be 18", cat.size()==expectedSize);
    }
}
