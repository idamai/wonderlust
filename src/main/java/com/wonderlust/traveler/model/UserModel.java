package com.wonderlust.traveler.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserModel implements Serializable {

	private static final long serialVersionUID = -489345994953037916L;

	private String email;
	private String password;
	private String role;

	protected UserModel() {
	}

	public UserModel(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

}
