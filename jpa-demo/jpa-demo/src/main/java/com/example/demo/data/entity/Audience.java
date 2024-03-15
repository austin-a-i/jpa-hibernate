package com.example.demo.data.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Audience {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Genre genre;
	
	@ManyToMany(mappedBy = "audiences")
	private List<Artist> artists = new ArrayList<>();
	
	protected Audience() {
	}
	
	public Audience(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	public List<Artist> getArtists() {
		return artists;
	}

	public void addArtists(Artist artist) {
		this.artists.add(artist);
	}
	
	public void removeArtists(Artist artist) {
		this.artists.remove(artist);
	}

	@Override
	public String toString() {
		return "Audience [" + name + "]";
	}

}
