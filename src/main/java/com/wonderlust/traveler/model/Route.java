package com.wonderlust.traveler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class Route implements Serializable {

	private static final long serialVersionUID = 1L;

	UserModel owner;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;

	@ManyToOne
	List<InterestPoint> interestPoints = new ArrayList<InterestPoint>();;

	public String getRouteId() {
		return id;
	}

	public UserModel getOwner() {
		return owner;
	}

	public void setOwner(UserModel owner) {
		this.owner = owner;
	}

	public List<InterestPoint> getInterestPoints() {
		return interestPoints;
	}

	public void addInterestPoint(InterestPoint interestPoint) {
		interestPoints.add(interestPoint);
	}

	public void removeInterestPoint(InterestPoint interestPoint) {
		interestPoints.remove(interestPoint);
	}

	public void setInterestPoints(List<InterestPoint> interestPoints) {
		this.interestPoints = interestPoints;
	}

}
