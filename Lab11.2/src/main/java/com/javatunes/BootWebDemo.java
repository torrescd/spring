package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.javatunes.config.SpringConfig;

@SpringBootApplication
@Import(SpringConfig.class)
public class BootWebDemo extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootWebDemo.class);
    }
	
    public static void main(String[] args) {
    	System.out.println("BootWebDemo.main() called");
        SpringApplication.run(BootWebDemo.class, args);
    }   
}
