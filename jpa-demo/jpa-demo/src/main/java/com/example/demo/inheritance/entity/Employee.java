package com.example.demo.inheritance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//Default type Inheritance
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String name;
	
	protected Employee() {}

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public long getId() {
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
		return String.format("Employee[%s]", name);
	}
	
}
