package com.wonderlust.traveler.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wonderlust.traveler.model.UserModel;

@Repository
public class UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "user";

	public void addUser(UserModel user) {
		if (!mongoTemplate.collectionExists(UserModel.class)) {
			mongoTemplate.createCollection(UserModel.class);
		}
		mongoTemplate.insert(user, COLLECTION_NAME);
	}

	public UserModel findByEmail(String email) {
		return mongoTemplate.findOne(new Query(Criteria.where("email")
				.is(email)), UserModel.class, COLLECTION_NAME);
	}

	public boolean existByEmail(String email) {
		return mongoTemplate.exists(
				new Query(Criteria.where("email").is(email)), UserModel.class);
	}

	public List<UserModel> listUser() {
		return mongoTemplate.findAll(UserModel.class, COLLECTION_NAME);
	}

	public void deleteUser(UserModel user) {
		mongoTemplate.remove(user, COLLECTION_NAME);
	}

	public void updateUser(UserModel user) {
		mongoTemplate.insert(user, COLLECTION_NAME);
	}

}
