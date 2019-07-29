/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.JpaItemRepository;

@Configuration
// TODO: add annotation to access the jdbc.properties file
public class SpringRepositoryConfig {

	// TODO: add the annotation to inject the Environment
	private Environment env; 
	
	// Complete - nothing you need to do in this method
	@Bean
	public static PropertySourcesPlaceholderConfigurer
	propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean DataSource javatunesDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();

		// TODO: get the "url" property and add it to the DS
		ds.setUrl("TODO");  

		ds.setDriverClassName(env.getProperty("javatunes.driverClassName"));
		ds.setUsername(env.getProperty("javatunes.dbUserName"));
		ds.setPassword(env.getProperty("javatunes.password"));


		return ds;
	}

	// Complete - nothing you need to do in this method
	@Bean
	public JpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setShowSql(true);
		va.setGenerateDdl(false);
		return va;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean javatunesEmf() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		// TODO: get the "persistenceUnitName" property and add it to the EM
		em.setPersistenceUnitName("TODO"); 

		em.setDataSource(javatunesDataSource());
		em.setPackagesToScan("com.javatunes.*");
		em.setJpaVendorAdapter(vendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}

	// Complete - nothing you need to do in this method
	private Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.dialect", env.getProperty("javatunes.dialect")); // I would have the student edit this in the properties file
	      return properties;
	   }

	// TODO: add the annotation to configure the bean
	public ItemRepository itemRepository() {
		return new JpaItemRepository();
	}

	// Create a transaction manager bean (more on this later)
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory( javatunesEmf().getObject());
		return transactionManager;
	}	

}