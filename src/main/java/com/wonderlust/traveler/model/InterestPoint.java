package com.wonderlust.traveler.model;

import java.io.Serializable;

import javax.persistence.ManyToMany;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InterestPoint implements Serializable {

	private static final long serialVersionUID = 2925303568193367785L;

	@ManyToMany
	private UserModel user;

	private Double[] location;

	@PersistenceConstructor
	public InterestPoint(UserModel user, Double[] location) {
		this.user = user;
		this.location = location;

	}

	public InterestPoint(UserModel user, Double pointX, Double pointY) {
		this.user = user;
		this.location = new Double[] { pointX, pointY };

	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Double[] getLocation() {
		return location;
	}

	public void setLocation(Double[] location) {
		this.location = location;
	}

}
