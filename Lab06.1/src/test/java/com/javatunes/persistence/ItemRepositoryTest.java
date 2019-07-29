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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class ItemRepositoryTest {

    // TODO: Inject the repository instance.
    ItemRepository repo;

	// Used to control transactions - we will do this much more elegantly soon.
    @Autowired
	private PlatformTransactionManager transactionManager;		
    
	@Test
	public void testFindOnePositive() {
		Long id = 1L;

		// Again - TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		System.out.println("\n*** Retrieving item from the database ***");
		MusicItem item = repo.findOne(id);
		assertNotNull("The MusicItem should not be null", item);
		System.out.println(item);
		System.out.println("***\n");
		
		transactionManager.commit(transaction);
	}

	// @Test
	public void testSavePositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		// Insert / persist an instance
		MusicItem newItem = new MusicItem();
		newItem.setArtist("Cat Stevens");
		newItem.setTitle("Tea for the Tillerman");
		newItem.setPrice(new BigDecimal("14.97"));
		newItem.setReleaseDate(LocalDate.now());	
		
		// TODO: Use the repo to save the item.
		
        transactionManager.commit(transaction);
		// Should be saved and have a valid id now.
		System.out.println("New item is: " + newItem);
        assertNotNull("Id should not be null", newItem.getId());

	}	

	// @Test
	public void testUpdatePositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		Long id = 1L;
		String newTitle = "New Title";
		
		// TODO: Get an item, and set its title to newTitle
		MusicItem item = null;
		
        transactionManager.commit(transaction);
        
        // Start a new transaction get the item, and check the new title.
        transaction = transactionManager.getTransaction(definition);
		item = repo.findOne(id);
		System.out.println(item);
		assertEquals("Title was not updated", newTitle, item.getTitle());
        
        transactionManager.commit(transaction);
	}		

	// @Test
	public void testDeletePositive() {
		Long id = 12L;

		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		System.out.println("\n*** Retrieving item from the database ***");
		// TODO: Get the item then delete it
		MusicItem item = null;
		
        transactionManager.commit(transaction);
        
        // Start a new transaction and try to get the item - it should be null
        transaction = transactionManager.getTransaction(definition);
		item = repo.findOne(id);
		assertNull("Deleted item should not be found", item);
        
        transactionManager.commit(transaction);
	}

	// @Test
	public void testFindAllPositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		System.out.println("\n*** Retrieving all items from the database ***");
		// TODO: Get all items from the repository instance
		Collection<MusicItem> allItems = null;
		assertFalse("All items result should not be empty", allItems.isEmpty());
	    System.out.println("\n\n");
	    System.out.println("***** Results from retrieving all music items *********");
	    for (MusicItem curItem : allItems) {
	    	System.out.println(curItem);
	    }

        transactionManager.commit(transaction);
	}

	// @Test
	public void testFindByArtistPositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
	    System.out.println("\n\n");
		System.out.println("\n*** Retrieving Sting items from the database ***");
		// TODO: Get artist Sting items from the repository instance
		Collection<MusicItem> allItems = null;
		assertFalse("Sting artist result should not be empty", allItems.isEmpty());
	    System.out.println("***** Results from retrieving by artist Sting  *********");
	    for (MusicItem curItem : allItems) {
	    	System.out.println(curItem);
	    }
	    System.out.println("\n\n");

	    System.out.println("\n*** Retrieving Madonna items from the database ***");
		// TODO: Get artist Maddona items from the repository instance
	    allItems = null;
		assertFalse("Sting artist result should not be empty", allItems.isEmpty());
	    System.out.println("***** Results from retrieving by artist Madonna  *********");
	    for (MusicItem curItem : allItems) {
	    	System.out.println(curItem);
	    }
	    System.out.println("\n\n");
	    
	    transactionManager.commit(transaction);
	}

}
