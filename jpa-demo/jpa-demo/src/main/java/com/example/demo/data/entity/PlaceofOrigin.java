package com.example.demo.data.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PlaceofOrigin {

	protected PlaceofOrigin() {}

	public PlaceofOrigin(String place) {
		super();
		this.setPlace_of_origin(place);
	}

	public String getPlace_of_origin() {
		return place_of_origin;
	}

	public void setPlace_of_origin(String place_of_origin) {
		this.place_of_origin = place_of_origin;
	}

	private String place_of_origin;

}
