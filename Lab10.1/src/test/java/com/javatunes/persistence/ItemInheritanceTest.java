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
import com.javatunes.domain.DownloadableMusicItem;
import com.javatunes.domain.MusicItem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class ItemInheritanceTest {

    // Inject a repository
	@Autowired
    ItemRepository repo;

	// Used to control transactions
    @Autowired
	private PlatformTransactionManager transactionManager;		
	
	@Test
	public void testInheritancePositive() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Get item with id == 1
		MusicItem mi = repo.findOne(new Long (1));
		System.out.println(mi);
		
		// We know that this is true based on our database
		assertTrue(mi instanceof DownloadableMusicItem);

		// Get all items and output for illustration - no tests done.
		Collection<MusicItem> allItems = repo.findAll();
		allItems.forEach(i -> System.out.println(i));
        transactionManager.commit(transaction);
	}
}
