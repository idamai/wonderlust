package com.wonderlust.traveler.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wonderlust.traveler.model.Route;
import com.wonderlust.traveler.model.UserModel;

@Repository
public class RouteRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "route";

	public void addRoute(Route route) {
		if (!mongoTemplate.collectionExists(Route.class)) {
			mongoTemplate.createCollection(Route.class);
		}
		mongoTemplate.insert(route, COLLECTION_NAME);
	}

	public Route getRouteById(String id) {
		return mongoTemplate.findById(id, Route.class, COLLECTION_NAME);
	}

	public List<Route> listRoute() {
		return mongoTemplate.findAll(Route.class, COLLECTION_NAME);
	}

	public List<Route> listRouteByUser(UserModel user) {
		return mongoTemplate.find(new Query(Criteria.where("owner").is(user)),
				Route.class, COLLECTION_NAME);
	}

	public void deleteRoute(Route route) {
		mongoTemplate.remove(route, COLLECTION_NAME);
	}

	public void updateRoute(Route route) {
		mongoTemplate.save(route, COLLECTION_NAME);
	}

}
