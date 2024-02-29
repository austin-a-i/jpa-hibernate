package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

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
	
	private String name;
	
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
	
	@Override
	public String toString() {
		return "Artist [" + name + "]";
	}
	
}
