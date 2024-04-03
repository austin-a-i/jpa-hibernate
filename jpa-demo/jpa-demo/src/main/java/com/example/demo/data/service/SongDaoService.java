package com.example.demo.data.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.data.entity.Artist;
import com.example.demo.data.entity.Song;
import com.example.demo.data.exception.ResourceNotFoundException;
import com.example.demo.data.repository.ArtistJpaRepository;
import com.example.demo.data.repository.SongJpaRepository;

@Service
public class SongDaoService {
	
	private SongJpaRepository songRepository;
	
	@Autowired
	private ArtistJpaRepository artistJpaRepository;

	public SongDaoService(SongJpaRepository songRepository, ArtistJpaRepository artistJpaRepository) {
		this.songRepository = songRepository;
		this.artistJpaRepository = artistJpaRepository;
	}
	
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}
	
	public EntityModel<Song> getSongById(long id) {
		Optional<Song> song = songRepository.findById(id);
		if(song.isEmpty()) {
			throw new ResourceNotFoundException("Not found Song with id: " + id);
		}
		EntityModel<Song> entityModel = EntityModel.of(song.get());
		return entityModel;
	}
	
	public List<Song> getSongsByArtistId(long artistId) {
		artistJpaRepository.findById(artistId)
			.orElseThrow(() -> new ResourceNotFoundException("Not found id: " + artistId));
		List<Song> songByArtistId = songRepository.findSongByArtistId(artistId);
		return songByArtistId;
	}
	
	public List<Song> getSongsByArtistName(String artistName) {
		Optional<Artist> artist = artistJpaRepository.findArtistByName(artistName);
		if(artist.isEmpty()) {
			throw new ResourceNotFoundException("Not found Artist with name " + artistName);
		}
		List<Song> songByArtistName = songRepository.findSongByArtistName(artistName);
		return songByArtistName;
	}
	
	public ResponseEntity<Song> addSongIfArtistExist(Song song) {
		if(artistJpaRepository.existsById(song.getArtist().getId())) {
			Song savedSong = songRepository.save(song);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
										.path("/{id}")
										.buildAndExpand(savedSong.getId())
										.toUri();
			return ResponseEntity.created(location).build();
		}
		else {
			throw new ResourceNotFoundException("Not found Artist with id: " + song.getArtist().getId());
		}
	}
	
	public void deleteSong(long id) {
		songRepository.deleteById(id);
	}
}
