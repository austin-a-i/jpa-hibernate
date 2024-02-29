package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.entity.Artist;

@SpringBootTest
class ArtistRepositoryTest {
	
	@Autowired
	ArtistRepository artistRepository;

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

}
