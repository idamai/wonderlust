package com.wonderlust.traveler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.wonderlust.traveler.model.InterestPoint;
import com.wonderlust.traveler.model.UserModel;
import com.wonderlust.traveler.repository.InterestPointRepository;

@Service
public class InterestPointService {
	@Autowired
	InterestPointRepository interestPointRepository;

	@Autowired
	UserService userService;

	public InterestPoint getInterestPointById(String id) {
		return interestPointRepository.getInterestPointById(id);
	}

	public List<InterestPoint> getInterestPoints() {
		return interestPointRepository.listInterestPoint();
	}

	public List<InterestPoint> getInterestPointsByUser() {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userService.getUserByEmail(principal.getUsername());

		return interestPointRepository.listInterestPointByUser(user);
	}

	public void addInterestPoint(InterestPoint interestPoint) {
		interestPointRepository.addInterestPoint(interestPoint);
	}

	public List<InterestPoint> getBoundedInterestPoint(Double x1, Double y1,
			Double x2, Double y2) {
		return interestPointRepository.geoBoundInterestPoint(x1, y1, x2, y2);
	}

	public void addInterestPoint(Double x, Double y) {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userService.getUserByEmail(principal.getUsername());
		InterestPoint newInterestPoint = new InterestPoint(user, x, y);
		interestPointRepository.addInterestPoint(newInterestPoint);
	}

	public void updateInterestPoint(InterestPoint interestPoint) {
		interestPointRepository.updateInterestPoint(interestPoint);
	}

	public void delete(InterestPoint interestPoint) {
		interestPointRepository.deleteInterestPoint(interestPoint);
	}

	public InterestPoint getNearestFromPoint(Double x, Double y) {
		List<InterestPoint> resultList = interestPointRepository
				.geoNearestInterestPoint(x, y);
		if (!resultList.isEmpty()) {
			return resultList.get(0);
		} else
			return null;

	}
}
