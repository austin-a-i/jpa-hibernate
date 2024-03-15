package com.example.demo.data.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entity.Artist;
import com.example.demo.data.entity.Audience;
import com.example.demo.data.entity.Genre;
import com.example.demo.data.entity.Song;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class ArtistRepository {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
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
	
	
	public void addSongsOfArtist() {
		Artist artist = findById(1003);
		log.info("Songs bt artist 1003 {}", artist.getSongs());
		
		//Add songs
		Song song1 = new Song("4.5", "Anchor");
		Song song2 = new Song("5", "Opalene");
		
		//Setting relationships
		artist.addSong(song1);
		song1.setArtist(artist);
		
		artist.addSong(song2);
		song2.setArtist(artist);
		
		//Saving to database
		entityManager.persist(song1);
		entityManager.persist(song2);
	}
	
	public void addSongsOfArtist(long artistId, List<Song> songs) {
		Artist artist = findById(artistId);
		log.info("Songs by artist {} - {}", artistId, artist.getSongs());
		
		
		for(Song song : songs) {
			artist.addSong(song);
			song.setArtist(artist);
			
			entityManager.persist(song);
		}
		
		log.info("Songs by artist {} - {}", artistId, artist.getSongs());
	}
	
	public void addArtistAndAudience() {
		Artist artist = new Artist("Martin Garrix");
		Audience audience = new Audience("EDM");
		entityManager.persist(artist);
		entityManager.persist(audience);
		
		artist.addAudience(audience);
		audience.addArtists(artist);
		entityManager.persist(artist);
	}
	
	/*
	 * When you have a two-sided relationship, JPA works in some situations when you
	 * just persist one side of the relationship (One to One, One to Many, Many to
	 * One). For Many to Many, you need to persist both.
	 */
	public void addArtistAndAudience(Artist artist, Audience audience) {		
		artist.addAudience(audience);
		audience.addArtists(artist);
		entityManager.persist(artist);
		entityManager.persist(audience);
	}
	
	public void retrieveArtistsWithGenre(long genreId, List<Artist> artists) {
		Genre genre = entityManager.find(Genre.class, genreId);
		for (Artist artist : artists) {
			genre.addArtist(artist);
			artist.setGenre(genre);
			
			//entityManager.persist(artist);
			entityManager.persist(genre);
		}
		log.info("Artists Genre {} - {}", genreId, genre.getArtists());
	}

}
