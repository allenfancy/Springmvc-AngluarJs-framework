package com.allen.springmvc.angular.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.allen.springmvc.angular.basic.dao.MongoDao;
import com.allen.springmvc.angular.model.UserModel;

@Repository
public class UserDao extends MongoDao<UserModel, String>{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public void save(UserModel userModel){}
	
	
	
	@Autowired
	@Override
	public void setInit() {
		// TODO Auto-generated method stub
		setCollectionName("userModel");
		setTclass(UserModel.class);
		setMongoTemplate(mongoTemplate);
	}

}
