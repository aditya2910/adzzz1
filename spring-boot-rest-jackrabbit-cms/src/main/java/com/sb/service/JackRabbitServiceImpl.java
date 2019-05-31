package com.sb.service;

import javax.jcr.LoginException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.core.TransientRepository;
import org.springframework.stereotype.Component;
//import com.fdc.util.logging.*;

@Component
public class JackRabbitServiceImpl {
	
	public void saveContent(String content) {
		System.out.println("i am saying Hello");
		
		Repository repository = new TransientRepository();

	    Session session = null;
		try {
			session = repository.login(
			        new SimpleCredentials("admin","admin".toCharArray()));
			
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

	    System.out.println("Hello World!");

	    session.logout();
	}

}
