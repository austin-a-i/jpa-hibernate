package com.example.demo.data.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "genre")
	private String favGenre;
	
	/*
	 * Mappedby on the non-owning side of the relationship to remove duplication
	 * In this way Audience will have Genre_Id but Genre wont have Audience id
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "genre")
	private Audience audience;
	
	@OneToMany(mappedBy = "genre")
	private List<Artist> artists = new ArrayList<>();
	
	protected Genre() {
	}
	
	public Genre(String favGenre) {
		this.favGenre = favGenre;
	}

	public Long getId() {
		return id;
	}

	public String getGenre() {
		return favGenre;
	}

	public void setGenre(String favGenre) {
		this.favGenre = favGenre;
	}
	
	public Audience getAudience() {
		return audience;
	}

	public void setAudience(Audience audience) {
		this.audience = audience;
	}
	
	public List<Artist> getArtists() {
		return artists;
	}

	public void addArtist(Artist artist) {
		this.artists.add(artist);
	}
	
	public void removeArtist(Artist artist) {
		this.artists.remove(artist);
	}

	@Override
	public String toString() {
		return "Genre [" + favGenre + "]";
	}
	
}
