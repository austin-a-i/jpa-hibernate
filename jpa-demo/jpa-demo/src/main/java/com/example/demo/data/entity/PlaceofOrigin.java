package com.example.demo.data.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PlaceofOrigin {
	String place_of_origin;

	protected PlaceofOrigin() {}

	public PlaceofOrigin(String place) {
		super();
		this.place_of_origin = place;
	}

}
