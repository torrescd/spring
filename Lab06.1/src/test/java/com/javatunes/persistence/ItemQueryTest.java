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
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.ArtistPriceInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class ItemQueryTest {

    // Inject an EntityManager
	@PersistenceContext
	private EntityManager em;

	// Used to control transactions - we will do this much more elegantly soon.
    @Autowired
	private PlatformTransactionManager transactionManager;		
	
	@Test
	public void testSimpleProjectionQueryPositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Simple Projection query 
		// TODO: Create  query string to get id and title, execute query, get results
		String projQuery = null;
		Query q = null;
		List<Object[]> results = null;
		
		assertFalse("Simple projection query result should not be empty", results.isEmpty());
		System.out.println("\n\n");
		System.out.println("***** Results from retrieving projection query *********");

		// TODO: Iterate through the results, and print out the id and title
		
        transactionManager.commit(transaction);
	}

	// @Test
	public void testArtistPriceInfoProjectionQueryPositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Projection query using Java object
		// TODO: Create query string, execute query, get results 
		String priceInfoQuery = null;
		TypedQuery<ArtistPriceInfo> q = null;
		List<ArtistPriceInfo> results = null;
		
		assertFalse("ArtistPriceInfo query result should not be empty", results.isEmpty());
		System.out.println("\n\n");
		System.out.println("***** Results from PriceInfo query *********");

		// TODO: Iterate through the results, and print out each one

        transactionManager.commit(transaction);
	}

	// @Test
	public void testAggregateQueryPositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Aggregate query		
		// TODO: Create query string, execute query, get results
		String agQuery = null;
		TypedQuery<BigDecimal> q = null;
		BigDecimal agResults = null;
		
		assertNotNull("Aggregate query result should not be null", agResults);
		System.out.println("\n\n");
		System.out.println("***** Results from aggregate query *********");
		System.out.println(agResults);
		
        transactionManager.commit(transaction);
	}	

	// @Test
	public void testGroupByQueryPositive() {
		// TX control that we'll do more elegantly later
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);

		// Optional - GROUP BY
		// TODO: Create query string, execute query, get results
		String groupQuery = null;
		Query q = null;
		List<Object[]> results = null;
		
		assertFalse("GroupBy query result should not be empty", results.isEmpty());
		System.out.println("\n\n");
		System.out.println("***** Results from GROUP BY query *********");
		
		// TODO: Iterate through the results, and print out each one - what does each result contain?

        transactionManager.commit(transaction);
	}	
}
