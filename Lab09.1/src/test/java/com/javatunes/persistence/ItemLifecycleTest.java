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

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
public class ItemLifecycleTest {

    // Inject an EntityManager
	@PersistenceContext
	private EntityManager em;

	// Used to control transactions - we will do this much more elegantly soon.
    @Autowired
	private PlatformTransactionManager transactionManager;	
    
	@Test
	public void testEntityManagerFlushBehavior() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// TODO: Look up an item, set its price to 19.99
		MusicItem anItem = null;
		
		// We query again for the item - is it here?
		TypedQuery<MusicItem> q = em.createQuery("SELECT m FROM MusicItem m WHERE m.price > 18.99 ", MusicItem.class);
	    List<MusicItem> resultList = q.getResultList();
	    System.out.println("***** Results from retrieving music items with price > 18.99 *********");
	    for (MusicItem curItem : resultList) {
	    	System.out.println(curItem);
	    }

        transactionManager.commit(transaction);
	}
/*
	@Test
	public void testVersioning() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Start a TX, get an entity, commit the TX, and it becomes detached
		MusicItem detachedItem = em.find(MusicItem.class, new Long(1));
		System.out.println("detached item: version = " + detachedItem.getVersion());
        transactionManager.commit(transaction);    			

        // Start a new TX, get managed entity, change it, commit the TX
		transaction = transactionManager.getTransaction(definition);
		MusicItem managedItem = em.find(MusicItem.class, new Long(1));
		System.out.println("managed item before modify: version = " + managedItem.getVersion());
		managedItem.setTitle(managedItem.getTitle() + "x");
		transactionManager.commit(transaction);
		System.out.println("managed item after modify: version = " + managedItem.getVersion());		
		System.out.println("detacheditem after modify: version = " + detachedItem.getVersion());		
		
		// Try to merge in the detached entity - it should throw an exception.
		transaction = transactionManager.getTransaction(definition);
		em.merge(detachedItem);
		transactionManager.commit(transaction);

	}
*/	
	// @Test
	public void testCallbacks() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		MusicItem anItem = em.find(MusicItem.class, new Long(1));

        transactionManager.commit(transaction);
	}	
	
}
