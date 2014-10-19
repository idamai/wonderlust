package com.wonderlust.traveler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.wonderlust.traveler.model.InterestPoint;
import com.wonderlust.traveler.model.Route;
import com.wonderlust.traveler.model.UserModel;
import com.wonderlust.traveler.repository.RouteRepository;

@Service
public class RouteService {

	@Autowired
	InterestPointService interestPointService;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	UserService userService;

	public void addPointToRoute(Route route, Double x, Double y) {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userService.getUserByEmail(principal.getUsername());
		InterestPoint interestPoint = new InterestPoint(user, x, y);
		addPointToRoute(route, interestPoint);
	}

	public void addPointToRoute(Route route, InterestPoint interestPoint) {
		interestPointService.addInterestPoint(interestPoint);
		route.addInterestPoint(interestPoint);
		routeRepository.updateRoute(route);
	}

	public void removePointFromRoute(Route route, InterestPoint interestPoint) {
		route.removeInterestPoint(interestPoint);
		interestPointService.delete(interestPoint);
		routeRepository.updateRoute(route);
	}

	public Route getRouteById(String id) {
		return routeRepository.getRouteById(id);
	}

	public Route generateRoute() {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userService.getUserByEmail(principal.getUsername());
		Route route = new Route();
		route.setOwner(user);
		addRoute(route);
		return route;
	}

	public void addRoute(Route route) {
		routeRepository.addRoute(route);
	}

	public void updateRoute(Route route) {
		routeRepository.updateRoute(route);
	}

	public void deleteRoute(Route route) {
		routeRepository.deleteRoute(route);
	}

	public List<Route> getAllRoutes() {
		return routeRepository.listRoute();
	}

	public List<Route> getAllRoutesByUser(UserModel user) {
		return routeRepository.listRouteByUser(user);
	}

	public List<Route> getAllRoutesOwnedByUser() {
		User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserModel user = userService.getUserByEmail(principal.getUsername());
		return routeRepository.listRouteByUser(user);
	}
}
