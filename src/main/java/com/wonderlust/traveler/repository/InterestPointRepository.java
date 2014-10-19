package com.wonderlust.traveler.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wonderlust.traveler.model.InterestPoint;
import com.wonderlust.traveler.model.UserModel;

@Repository
public class InterestPointRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "interest_point";

	public void addInterestPoint(InterestPoint interestPoint) {
		if (!mongoTemplate.collectionExists(InterestPoint.class)) {
			mongoTemplate.createCollection(InterestPoint.class);
		}
		mongoTemplate.insert(interestPoint, COLLECTION_NAME);
	}

	public List<InterestPoint> listInterestPoint() {
		return mongoTemplate.findAll(InterestPoint.class, COLLECTION_NAME);
	}

	public List<InterestPoint> listInterestPointByUser(UserModel user) {
		return mongoTemplate.find(new Query(Criteria.where("user").is(user)),
				InterestPoint.class, COLLECTION_NAME);
	}

	public void deleteInterestPoint(InterestPoint interestPoint) {
		mongoTemplate.remove(interestPoint, COLLECTION_NAME);
	}

	public void updateInterestPoint(InterestPoint interestPoint) {
		mongoTemplate.save(interestPoint, COLLECTION_NAME);
	}

	public List<InterestPoint> geoBoundInterestPoint(Double x1, Double y1,
			Double x2, Double y2) {
		Box box = new Box(new Point(x2, y2), new Point(x1, y1));
		return mongoTemplate.find(
				new Query(Criteria.where("location").within(box)),
				InterestPoint.class, COLLECTION_NAME);
	}

	public List<InterestPoint> geoNearestInterestPoint(Double x, Double y) {
		Circle circle = new Circle(x, y, 0.00005);
		return mongoTemplate.find(new Query(Criteria.where("location")
				.withinSphere(circle)), InterestPoint.class, COLLECTION_NAME);
	}

	public InterestPoint getInterestPointById(String id) {

		return mongoTemplate.findById(id, InterestPoint.class, COLLECTION_NAME);
	}
}
