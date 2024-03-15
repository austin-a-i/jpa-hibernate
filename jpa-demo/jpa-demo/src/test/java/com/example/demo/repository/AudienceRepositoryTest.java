package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entity.Artist;
import com.example.demo.data.entity.Audience;
import com.example.demo.data.entity.Genre;
import com.example.demo.data.repository.AudienceRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
class AudienceRepositoryTest {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AudienceRepository audienceRepository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void retrieveAudienceAndGenre() {
		//Audience audience = em.find(Audience.class, 2001);
		Audience audience = audienceRepository.findById(2001);
		log.info("Audience {}", audience);
		log.info("Audience Genre - {}", audience.getGenre());
	}

	@Test
	@Transactional
	void retrieveGenreAndAudience() {
		Genre genre = em.find(Genre.class, 4001);
		log.info("Genre {}", genre);
		log.info("Genre Audience - {}", genre.getAudience());
	}
	
	@Test
	@Transactional
	void retrieveAudienceAndArtist() {
		Audience audience = em.find(Audience.class, 2002);
		log.info("Audience: {} - Artist: {}", audience, audience.getArtists());
	}
}
