package com.wonderlust.traveler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wonderlust.traveler.model.UserModel;
import com.wonderlust.traveler.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	public UserModel getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<UserModel> getAllUser() {
		return userRepository.listUser();
	}

	public void signUp(String email, String password) {

		String encoded = passwordEncoder.encode(password);
		UserModel user = new UserModel(email, encoded, "ROLE_USER");
		userRepository.addUser(user);

	}

}