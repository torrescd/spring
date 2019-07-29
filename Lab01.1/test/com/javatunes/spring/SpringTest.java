/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void testContextNotNullPositive() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
		assertNotNull("spring container should not be null", ctx);
		System.out.println("Spring was bootstrapped for environment " + ctx.getEnvironment());
		ctx.close();
	}

}
