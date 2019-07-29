/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class JPATest {

	private static EntityManagerFactory emf = null;    

    @BeforeClass
    public static void setUpEntityManagerFactory() {
		// TODO - Create an entity manager factory (use the Persistence type)
		emf = null;
	}

    @AfterClass
    public static void closeEntityManagerFactory() {
		// TODO: Close the EMF
	}

	@Test
	public void testFindOnePositive() {
		EntityManager em = null;  // TODO - Create from the entity manager factory
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			MusicItem m = null;  // TODO - Retrieve the item with id of 1
			assertNotNull("The MusicItem should not be null", m);
			System.out.println(m);
			tx.commit();
		}
		catch (Exception ex) { ex.printStackTrace(); }
		finally { 
			em.close();
		}
	}
}
