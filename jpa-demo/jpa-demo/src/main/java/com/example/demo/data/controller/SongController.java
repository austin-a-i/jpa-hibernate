package com.example.demo.data.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entity.Song;
import com.example.demo.data.service.SongDaoService;

import jakarta.validation.Valid;

@RestController
public class SongController {
	
	private SongDaoService songService;

	public SongController(SongDaoService songService) {
		this.songService = songService;
	}
	
	@GetMapping("/songs")
	public List<Song> retrieveAllSongs() {
		return songService.getAllSongs();
	}
	
	@GetMapping("/songs/artist/id/{artistId}")
	public List<Song> retrieveAllSongsByArtistId(@PathVariable long artistId) {
		return songService.getSongsByArtistId(artistId);
	}
	
	@GetMapping("/songs/artist/{artistName}")
	public List<Song> retrieveAllSongsByArtistName(@PathVariable String artistName) {
		return songService.getSongsByArtistName(artistName);
	}

	@GetMapping("/songs/{id}")
	public EntityModel<Song> retrieveSongById(@PathVariable long id) {
		EntityModel<Song> entityModel = songService.getSongById(id);
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllSongs());
		entityModel.add(link.withRel("all-songs"));
		
		return entityModel;
	}

	@PostMapping("/songs")
	public ResponseEntity<Song> addSong(@Valid @RequestBody Song song) {
		return songService.addSongIfArtistExist(song);
	}
	
	@PutMapping("/songs/{id}")
	public ResponseEntity<Song> updateSong(@PathVariable long id, @Valid @RequestBody Song song) {
		return songService.addSongIfArtistExist(song);
	}
	
	@DeleteMapping("/songs/{id}")
	public void deleteSongById(@PathVariable long id) {
		songService.deleteSong(id);	
	}

}
