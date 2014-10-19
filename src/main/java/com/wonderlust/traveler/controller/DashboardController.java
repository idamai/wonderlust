package com.wonderlust.traveler.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class DashboardController {
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String index() {
		return "dashboard";
	}
}