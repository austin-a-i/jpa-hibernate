package com.example.demo.data.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_artists", query = "Select a From Artist a"),
		@NamedQuery(name = "query_get_Ed Sheeran", 
			query = "select a from Artist a where name like '%Sheeran'")
})
public class Artist {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	//By Default, OnetoMany FetchType is LAZY
	// **ToMany - By Default - LAZY fetching
	@OneToMany(mappedBy = "artist")
	private List<Song> songs = new ArrayList<>();
	
	//To customize Join Table name and fields
	@ManyToMany
	@JoinTable(name = "Artist_Audience",
			joinColumns = @JoinColumn(name = "Artist_Id"), 
			inverseJoinColumns = @JoinColumn(name = "Audience_ID"))
	private List<Audience> audiences = new ArrayList<>();
	
	@ManyToOne
	private Genre genre;
	
	protected Artist() {
	}
	
	public Artist(String name) {
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
	
	public List<Song> getSongs() {
		return songs;
	}

	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public void removeSong(Song song) {
		this.songs.remove(song);
	}
	
	public List<Audience> getAudiences() {
		return audiences;
	}

	public void addAudience(Audience audience) {
		this.audiences.add(audience);
	}
	
	public void removeAudience(Audience audience) {
		this.audiences.remove(audience);
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Artist [" + name + "]";
	}
	
}
