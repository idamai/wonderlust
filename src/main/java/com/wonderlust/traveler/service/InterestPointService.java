package com.wonderlust.traveler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.wonderlust.traveler.model.InterestPoint;
import com.wonderlust.traveler.model.UserModel;
import com.wonderlust.traveler.repository.InterestPointRepository;
import com.wonderlust.traveler.repository.UserRepository;

@Service
public class InterestPointService {
	@Autowired
	InterestPointRepository interestPointRepository;

	@Autowired
	UserRepository userRepository;

	public List<InterestPoint> getInterestPoints() {
		return interestPointRepository.listInterestPoint();
	}

	public List<InterestPoint> getInterestPointsByUser() {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userRepository.findByEmail(principal.getUsername());

		return interestPointRepository.listInterestPointByUser(user);
	}

	public void addInterestPoint(InterestPoint interestPoint) {
		interestPointRepository.addInterestPoint(interestPoint);
	}

	public List<InterestPoint> getBoundedCrimeEntries(Double x1, Double y1,
			Double x2, Double y2) {
		return interestPointRepository.geoBoundInterestPoint(x1, y1, x2, y2);
	}

	public void addInterestPoint(InterestPoint preceedingInterestPoint,
			Double x, Double y) {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userRepository.findByEmail(principal.getUsername());
		InterestPoint newInterestPoint = new InterestPoint(user, x, y);
		newInterestPoint.setPreceedingPoint(preceedingInterestPoint);
		if (preceedingInterestPoint != null) {
			preceedingInterestPoint.setProceedingPoint(newInterestPoint);
		}
		interestPointRepository.addInterestPoint(newInterestPoint);
		interestPointRepository.updateInterestPoint(preceedingInterestPoint);
	}

	public void endRoute(InterestPoint interestPoint) {
		interestPoint.setProceedingPoint(null);
		interestPointRepository.updateInterestPoint(interestPoint);
	}

	public void delete(InterestPoint interestPoint) {
		InterestPoint proceedingPoint = interestPoint.getPreceedingPoint();
		InterestPoint preceedingPoint = interestPoint.getProceedingPoint();
		if (proceedingPoint != null) {
			proceedingPoint.setPreceedingPoint(preceedingPoint);
		}
		if (preceedingPoint != null) {
			preceedingPoint.setProceedingPoint(proceedingPoint);
		}
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
