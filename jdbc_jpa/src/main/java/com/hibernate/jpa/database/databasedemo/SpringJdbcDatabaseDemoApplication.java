package com.hibernate.jpa.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.jpa.database.databasedemo.entity.Person;
import com.hibernate.jpa.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDatabaseDemoApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(SpringJdbcDatabaseDemoApplication.class);

	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All users -> {}", dao.findAll());
		log.info("User id 10001 -> {}", dao.findById(10001));
		log.info("Delete users -> {)", dao.deleteById(10002));
		log.info("Inserting users ", dao.insertValues(new Person(10005, "Tambe", "Indore")));
		log.info("Updating users ", dao.updateValues(new Person(10003, "Albusch", "Amsterdam")));
	}

}
