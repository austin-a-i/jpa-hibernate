package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entity.Artist;
import com.example.demo.data.entity.Song;
import com.example.demo.data.repository.ArtistRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
class ArtistRepositoryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	void testFindById() {
		Artist artist = artistRepository.findById(1001);
		assertEquals("Ed Sheeran", artist.getName());
	}
	
	//DirtiesContext allows Spring to automatically reset data to earlier state after the test
	@Test
	@DirtiesContext
	void testDeleteById() {
		artistRepository.deleteById(1002);
		assertNull(artistRepository.findById(1002));
	}
	
	@Test
	@DirtiesContext
	void testSaveArtist() {
		//get song
		Artist artist = artistRepository.findById(1003);
		assertEquals("Novo Amor", artist.getName());
		
		//update
		artist.setName("Hollow Coves");
		artistRepository.saveArtist(artist);
		
		//check
		Artist artist1 = artistRepository.findById(1003);
		assertEquals("Hollow Coves", artist1.getName());

	}
	
	@Test
	@Transactional
	void retrieveSongsByArtist() {
		Artist artist = artistRepository.findById(1001);
		log.info("{}", artist.getSongs());
	}
	
	@Test
	@Transactional
	void retrieveArtistsSongs() {
		Song song = entityManager.find(Song.class, 5001);
		log.info("{}", song.getArtist());
	}
	
	@Test
	@Transactional
	void retrieveArtistAudience() {
		Artist artist = entityManager.find(Artist.class, 1001);
		log.info("Artist: {} - Audience: {}", artist, artist.getAudiences());
	}
}
