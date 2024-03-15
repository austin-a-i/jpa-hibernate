package com.example.demo.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	@Column(name = "songname")
	private String songName;
	
	// Fetching always EAGER for ManytoOne
	@ManyToOne
	private Artist artist;
	
	protected Song() {
	}
	
	public Song(String rating, String songName) {
		this.rating = rating;
		this.songName = songName;
	}

	public Long getId() {
		return id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Song [rating=" + rating + ", songName=" + songName + "]";
	}
	
}
