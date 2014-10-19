package com.wonderlust.traveler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wonderlust.traveler.model.InterestPoint;
import com.wonderlust.traveler.service.InterestPointService;

@Controller
@RequestMapping("/api/interestpoint")
public class InterestPointController {
	@Autowired
	InterestPointService interestPointService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	List<InterestPoint> getByUser() {
		return interestPointService.getInterestPointsByUser();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	List<InterestPoint> getAll() {
		return interestPointService.getInterestPoints();
	}

	@RequestMapping(value = "/nearest", method = RequestMethod.GET)
	List<InterestPoint> getNearest(@RequestParam Double x,
			@RequestParam Double y) {
		return interestPointService.getInterestPoints();
	}

}
