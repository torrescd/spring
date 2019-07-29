/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloBootWorld {

    public static void main(String[] args) {
    	System.out.println("HelloBootWorld.main() called");
        SpringApplication.run(HelloBootWorld.class, args);
    }   
}
