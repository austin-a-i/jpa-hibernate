package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Artist;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class ArtistRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public Artist findById(long id) {
		return entityManager.find(Artist.class, id);
	}
	
	public Artist saveArtist(Artist artist) {
		if (artist.getId() == null) {
			entityManager.persist(artist);
		} else {
			entityManager.merge(artist);
		}
		return artist;
	}
	
	public void deleteById(long id) {
		Artist artist = findById(id);
		entityManager.remove(artist);
	}
	
	/*
	 * All changes done are updated irrespective of the save method due to the @Transaction annotation
	 * because it will be viewed as one transaction
	 */
	public void playWithEntityManager() {
		Artist artist = new Artist("Ben Plat");
		entityManager.persist(artist);
		
		artist.setName("Ben Platt");
	}

}
