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
import java.util.Iterator;

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
public class ItemRelationshipWorkTest {

    // Inject a repository
	@Autowired
    ItemRepository repo;

	// Used to control transactions - we will do this much more elegantly soon.
    @Autowired
	private PlatformTransactionManager transactionManager;		
	

	// ****  Test to be run without cascading set
	@Test
	public void testInventoryAddNoCascadeNegative() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		MusicItem mi = repo.findOne(new Long (5));
		int oldSize = mi.getInventoryRecords().size();
		System.out.format("Old size is %d\n", oldSize);
		
		// TODO: Add a new inventory record.
		
		
		// Commit the TX, start a new one.
        transactionManager.commit(transaction);
        transaction = transactionManager.getTransaction(definition);
        
        mi = repo.findOne(new Long (5));
        int newSize = mi.getInventoryRecords().size();
        System.out.format("New size is %d\n", newSize);
		// Test to make sure it's empty (we know it is based on our data).
		assertNotEquals("Counts should not be equal", oldSize, newSize);
		
        transactionManager.commit(transaction);
	}

	// ****  Test to be run without cascading set	
	// @Test
	public void testInventoryUpdateNoCascadePositive() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		MusicItem mi = repo.findOne(new Long (1)); 
		
		int oldCount = 0;
		boolean first = true;  // Flag to indicate we're on first inventory record.
		
		// TODO: Get the inventory records
		Collection<Inventory> inventoryRecords = null;
		
		System.out.println("\n** Inventory records before updating count **");
		// Save first count, and update all counts
		for (Inventory cur: inventoryRecords) {
			if (first) {
				oldCount = cur.getQuantity();
				first = false;
			}
			System.out.println(cur);
			cur.setQuantity(cur.getQuantity()+100);
			
		}
		System.out.println();
		// Commit the TX, start a new one.
        transactionManager.commit(transaction);
        transaction = transactionManager.getTransaction(definition);
        
        // Reset first flag, get item and its records again.
        first = true;
		mi = repo.findOne(new Long (1));
		inventoryRecords = mi.getInventoryRecords();
		System.out.println("\n** Inventory records AFTER updating count **");       
		for (Inventory cur: inventoryRecords) {
			if (first) {
				// Test to make sure update of quantity worked even without cascading.
				assertNotEquals("Counts should not be equal", oldCount, cur.getQuantity());
				first = false;
			}
			System.out.println(cur);
		}
		System.out.println();
		transactionManager.commit(transaction);
	}	

	// **** Test to be run WITHOUT orphan removal
	// @Test
	public void testRemoveNoOrphanRemovalNegative() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		MusicItem mi = repo.findOne(new Long (1));

		// TODO: Get the inventory records and their size
		Collection<Inventory> inventoryRecords = null;
		int oldSize = 0;
		
		System.out.println("\nInventory before removal");
		inventoryRecords.forEach(cur->System.out.println(cur)); // Java 8 stream version of looping over collection
		System.out.println();
		Iterator<Inventory> i = inventoryRecords.iterator();
		Inventory anInventory = i.next();  // Get the first inventory record.
		
		// TODO: Remove this inventory record
		

		transactionManager.commit(transaction);
		transaction = transactionManager.getTransaction(definition);
		
		mi = repo.findOne(new Long (1));
		
		// TODO: Get the inventory records and size again
		inventoryRecords = null;
		int newSize = 0;
		
		System.out.println("\nInventory after removal");
		inventoryRecords.forEach(cur->System.out.println(cur));
		System.out.println();
		
		// This test should FAIL here
		assertNotEquals("Inventory sizes should not be equal after removal", oldSize, newSize);
		
		transactionManager.commit(transaction);
	}	

	// **** Test to be run WITH orphan removal
	// @Test
	public void testRemoveWithOrphanRemovalPositive() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		MusicItem mi = repo.findOne(new Long (1));

		// TODO: Get the inventory records and their size
		Collection<Inventory> inventoryRecords = null;
		int oldSize = 0;
		
		System.out.println("\nInventory before removal");
		inventoryRecords.forEach(cur->System.out.println(cur)); // Java 8 stream version of looping over collection
		System.out.println();
		Iterator<Inventory> i = inventoryRecords.iterator();
		Inventory anInventory = i.next();

		// TODO: Remove the record
		

		transactionManager.commit(transaction);
		transaction = transactionManager.getTransaction(definition);
		
		mi = repo.findOne(new Long (1));
		
		// TODO: Get the inventory records and size again
		inventoryRecords = null;
		int newSize = 0;
		
		System.out.println("\nInventory after removal");
		inventoryRecords.forEach(cur->System.out.println(cur));
		System.out.println();
		
		// This test should SUCCEED now
		assertNotEquals("Inventory sizes should not be equal after removal", oldSize, newSize);
		
		transactionManager.commit(transaction);
	}	

	
	// @Test
	public void testLazyFetchIllustrateOnly() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		MusicItem mi = repo.findOne(new Long (1));
		Collection<Inventory> inventoryRecords = mi.getInventoryRecords();
		System.out.println("\nAbout to display inventory records");
		inventoryRecords.forEach(cur->System.out.println(cur)); // Java 8 stream version of looping over collection
		System.out.println();
		transactionManager.commit(transaction);
	}	

	
	// @Test
	// @Test(expected = LazyInitializationException.class)  // Can do it this way to pass the test when exception thrown.
	public void testLazyFetchNegative() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		MusicItem mi = repo.findOne(new Long (1));
		transactionManager.commit(transaction);
		
		Collection<Inventory> inventoryRecords = mi.getInventoryRecords();
		System.out.println("\nAbout to display inventory records");
		inventoryRecords.forEach(cur->System.out.println(cur)); // Java 8 stream version of looping over collection
		System.out.println();
	}

}
