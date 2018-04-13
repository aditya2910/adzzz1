package com.sd.mongo.mongotransaction.dao.task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String > {

}
