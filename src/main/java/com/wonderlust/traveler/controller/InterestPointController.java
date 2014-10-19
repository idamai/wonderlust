package com.wonderlust.traveler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonderlust.traveler.model.InterestPoint;
import com.wonderlust.traveler.service.InterestPointService;

@Controller
@RequestMapping(value = "/api/interest-point")
public class InterestPointController {

	@Autowired
	InterestPointService interestPointService;

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	InterestPoint getInterestPoint(@RequestParam String id) {
		return interestPointService.getInterestPointById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/update-point", method = RequestMethod.POST)
	InterestPoint updatePoint(@RequestParam String id,
			@RequestParam String videoToken, @RequestParam String address,
			@RequestBody String description) {
		InterestPoint interestPoint = interestPointService
				.getInterestPointById(id);
		interestPoint.setAddress(address);
		interestPoint.setDescription(description);
		interestPoint.setVideoToken(videoToken);
		interestPointService.updateInterestPoint(interestPoint);
		return interestPoint;
	}
}
