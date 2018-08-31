package com.sd.mongo.mongotransaction.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sd.mongo.mongotransaction.dao.task.Task;
import com.sd.mongo.mongotransaction.dao.task.TaskRepository;
import com.sd.mongo.mongotransaction.dao.user.User;
import com.sd.mongo.mongotransaction.dao.user.UserRepository;

@RestController
@RequestMapping("/mongoTransaction")
public class MongoResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String startWork() {
		
		saveUserAndUpdateTask();
		
		return "hello";
	}


	@Transactional
	private void saveUserAndUpdateTask() {
		try {
			User user = new User();
			user.setName("Priyam");
			userRepository.save(user);
			
			//Thread.sleep(10000);
			
			Task task = new Task();
			//task.setId("srtgsr");
			task.setName("test-task1");
			//throw Exception();
			taskRepository.save(task);
			
			String name = userRepository.findByName("Priyam");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
