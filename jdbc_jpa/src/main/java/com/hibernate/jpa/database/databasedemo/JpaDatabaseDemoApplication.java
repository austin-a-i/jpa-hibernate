package com.hibernate.jpa.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.jpa.database.databasedemo.entity.Person;
import com.hibernate.jpa.database.databasedemo.jpa.PersonJpaRepostiory;

@SpringBootApplication
public class JpaDatabaseDemoApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(JpaDatabaseDemoApplication.class);

	@Autowired
	PersonJpaRepostiory repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("User id 10001 -> {}", repository.findById(10001));
		
		log.info("Inserting users ", repository.insertPerson(new Person(10005, "Tambe", "Indore")));
		log.info("Updating users ", repository.updatePerson(new Person(10003, "Albusch", "Amsterdam")));
		repository.deleteById(10002);
		log.info("All users -> {}", repository.findAll());
		
		}

}
