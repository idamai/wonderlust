package com.wonderlust.traveler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonderlust.traveler.model.Route;
import com.wonderlust.traveler.service.RouteService;

@Controller
@RequestMapping("/api/route")
public class RouteController {
	@Autowired
	RouteService routeService;

	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	List<Route> getByUser() {
		return routeService.getAllRoutesOwnedByUser();
	}

	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	List<Route> getAll() {
		return routeService.getAllRoutes();
	}

	@ResponseBody
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	Route create() {
		return routeService.generateRoute();
	}

	@ResponseBody
	@RequestMapping(value = "/add-point", method = RequestMethod.POST)
	Route addPoint(@RequestParam Double x, @RequestParam Double y,
			@RequestParam String id) {
		Route route = routeService.getRouteById(id);
		routeService.addPointToRoute(route, x, y);
		return route;
	}

}
