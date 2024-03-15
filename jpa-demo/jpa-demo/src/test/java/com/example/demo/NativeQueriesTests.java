package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.entity.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SpringBootTest
class NativeQueriesTests {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;

	
	@Test
	void testCreateNativeQuery() {
		Query query = entityManager.createNativeQuery("SELECT * FROM ARTIST", Artist.class);
		List<?> resultList = query.getResultList(); 
		log.info("SELECT * FROM ARTIST -> {}", resultList);
	}

	@Test
	void testCreateNativeQuery_withParameters() {
		Query query = entityManager.createNativeQuery("SELECT * FROM ARTIST where id = ?", Artist.class);
		query.setParameter(1, 1001);
		List<?> resultList = query.getResultList(); 
		log.info("SELECT * FROM ARTIST where id = ? -> {}", resultList);
	}
	
	@Test
	void testCreateNativeQuery_withNamedParameters() {
		Query query = entityManager.createNativeQuery("SELECT * FROM ARTIST where id = :id", Artist.class);
		query.setParameter("id", 1001);
		List<?> resultList = query.getResultList(); 
		log.info("SELECT * FROM ARTIST where id = :id -> {}", resultList);
	}

}
