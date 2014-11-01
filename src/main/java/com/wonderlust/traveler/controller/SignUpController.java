package com.wonderlust.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wonderlust.traveler.service.UserService;

@Controller
public class SignUpController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@RequestParam String email,
			@RequestParam String password) {
		userService.signUp(email, password);
		return "login";
	}
}