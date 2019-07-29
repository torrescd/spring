/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.Inventory;
import com.javatunes.domain.MusicItem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class ItemRelationshipTest {

    // Inject a repository
	@Autowired
    ItemRepository repo;

	// Used to control transactions
    @Autowired
	private PlatformTransactionManager transactionManager;		
	
	// @Test
	public void testInventoryAccessPositive() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Get item with id == 1
		MusicItem mi = repo.findOne(new Long (1));

		// TODO: Get its inventory records
		Collection<Inventory> inventoryRecords = null;
		
		assertNotNull("inventoryRecords should not be null", inventoryRecords);
		assertFalse("This item should have inventory records", inventoryRecords.isEmpty());
		
		// Print out all the records.
		System.out.println("\n***Inventory records for item with id == 1:***");
		for (Inventory cur: inventoryRecords) {
			System.out.println(cur);
		}
		System.out.println("***    ***\n");
		
        transactionManager.commit(transaction);
	}

	@Test
	public void testInventoryAddPositive() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Get item with id == 5
		MusicItem mi = repo.findOne(new Long (5));
		// Test to make sure it's empty (we know it is based on our data).
		assertTrue("This item should not have inventory records", mi.getInventoryRecords().isEmpty());
		
		// TODO: Add an inventory record using the addInventoryRecord helper method
		

		// Commit the TX, start a new one.
        transactionManager.commit(transaction);
        transaction = transactionManager.getTransaction(definition);
        
        // Get the item again in the new TX
        mi = repo.findOne(new Long (5));
		// Get its inventory records - there should be one only.
		Collection<Inventory> inventoryRecords = mi.getInventoryRecords();
		assertTrue("Should be one inventory record", inventoryRecords.size()==1);
		
        transactionManager.commit(transaction);
	}

}
