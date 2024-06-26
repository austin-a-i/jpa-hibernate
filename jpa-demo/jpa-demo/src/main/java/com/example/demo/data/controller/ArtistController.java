package com.example.demo.data.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.data.entity.Artist;
import com.example.demo.data.exception.ResourceNotFoundException;
import com.example.demo.data.service.ArtistDaoService;

import jakarta.validation.Valid;

@RestController
public class ArtistController {
	
	@Autowired
	private ArtistDaoService artistService;
	
	public ArtistController(ArtistDaoService artistDaoService) {
		this.artistService = artistDaoService;
	}
	
	@GetMapping("/artists")
	public List<Artist> retrieveAllArtists() {
		return artistService.getAllArtists();
	}

	@GetMapping("/artists/{id}")
	public EntityModel<Optional<Artist>> retrieveArtistById(@PathVariable long id) {
		Optional<Artist> artist = artistService.getArtist(id);
		if (! artist.isPresent()) {
			throw new ResourceNotFoundException("Not found id: " + id);
		}
		EntityModel<Optional<Artist>> entityModel = EntityModel.of(artist);
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllArtists());
		entityModel.add(link.withRel("all-artists"));
		
		return entityModel;
	}
	
	@PostMapping("/artists")
	public ResponseEntity<Artist> addArtist(@Valid @RequestBody Artist artist) {
		Artist savedArtist = artistService.addArtist(artist);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedArtist.getId())
									.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/artists/{id}")
	public void deleteArtistById(@PathVariable long id) {
		artistService.deleteArtist(id);	
	}

}