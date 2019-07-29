/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ARunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("ARunner.run");
		for (String cur : arg0) {
			System.out.println(cur);
		}
	}

}
