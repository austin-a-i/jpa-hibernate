package com.example.demo.data.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entity.Artist;
import com.example.demo.data.entity.Song;
import com.example.demo.data.exception.ResourceNotFoundException;
import com.example.demo.data.repository.ArtistJpaRepository;
import com.example.demo.data.repository.SongJpaRepository;

import jakarta.persistence.EntityManager;

@Service
public class ArtistDaoService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArtistJpaRepository artistRepository;
	
	@Autowired
	private SongJpaRepository songRepository;
	
	@Autowired
	EntityManager em;
	
	public List<Artist> getAllArtists(){
		return (List<Artist>) artistRepository.findAll();
	}
	
	public Optional<Artist> getArtist(long id){
		return artistRepository.findById(id);
	}
	
	@Transactional
	public Artist addArtist(Artist artist) {		
		artistRepository.save(artist);
		em.persist(artist);	 
		return artist;
	}
	
	@Transactional
	public void deleteArtist(long id){
		artistRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Not found id: " + id));
		List<Song> songByArtistId = songRepository.findSongByArtistId(id);
		if(! songByArtistId.isEmpty()) {
			// Optionally, you can choose to cascade delete associated songs
            // songRepository.deleteAll(songs);
            
            // Alternatively, throw an exception indicating that deletion cannot be performed
			log.info("Songs by artist" + id + " - "  + songByArtistId);
            throw new IllegalStateException("Cannot delete artist with associated songs");
		}
			artistRepository.deleteById(id);
		
	}
}
