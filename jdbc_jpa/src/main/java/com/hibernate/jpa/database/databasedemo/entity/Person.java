package com.hibernate.jpa.database.databasedemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

/*
 * @Table(name="<Table name>" also used if the Entity name doesn't match with Table name
 * */

@Entity
@NamedQuery(name="find_all_persons", query = "select p from Person p")
public class Person {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	
	public Person() {}
	
	public Person(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Person(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return String.format("\nPerson [id=%s, name=%s, location=%s]", id, name, location);
	}
	
}
