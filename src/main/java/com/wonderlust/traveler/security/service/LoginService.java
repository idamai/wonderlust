package com.wonderlust.traveler.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wonderlust.traveler.model.UserModel;
import com.wonderlust.traveler.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService {
	private UserRepository userRepository;

	@Autowired
	public LoginService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserModel user = userRepository.findByEmail(username);

		if (user == null)
			throw new UsernameNotFoundException("Oops!");

		List<SimpleGrantedAuthority> authorities = Arrays
				.asList(new SimpleGrantedAuthority(user.getRole()));

		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}