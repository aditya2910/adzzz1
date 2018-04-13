package com.sd.mongo.mongotransaction.dao.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String > {

}
