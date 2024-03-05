package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@SpringBootTest
class JPQLTests {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;

	
	@Test
	void testCreateQuery() {
		Query query = entityManager.createNamedQuery("query_get_all_artists");
		List<?> resultList = query.getResultList(); 
		log.info("Select a From Artist a -> {}", resultList);
	}

	@Test
	void testCreateTypedQuery() {
		TypedQuery<Artist> query = entityManager.createQuery("query_get_all_artists", Artist.class);
		List<Artist> resultList = query.getResultList(); 
		log.info("Select a From Artist a -> {}", resultList);
	}
	
	@Test
	void testCreateTypedQuery_where() {
		TypedQuery<Artist> query = entityManager.createQuery("select s from Songs s where name like '%Stars'", Artist.class);
		List<Artist> resultList = query.getResultList(); 
		log.info("select a from Artist a where name like '%Sheeran'-> {}", resultList);
	}

	

}
