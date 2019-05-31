package com.sb.service;

import javax.jcr.LoginException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//import com.fdc.util.logging.*;

import com.sb.config.Traceable;

@Component
public class JackRabbitServiceImpl {

	Logger LOGGER = LoggerFactory.getLogger(JackRabbitServiceImpl.class);

	@Traceable
	public void saveContent(String content) {
		System.out.println("i am saying Hello");
		Session session = null;
		try {
			Repository repository = JcrUtils.getRepository();
			
			session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
			
			logDescrioptionOfRepositoryAndSession(repository, session);
			
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

		System.out.println("Hello World!");

		session.logout();
	}

	private void logDescrioptionOfRepositoryAndSession(Repository repository, Session session) {
		String vendor = repository.getDescriptor(Repository.REP_VENDOR_DESC);
		String product = repository.getDescriptor(Repository.REP_NAME_DESC);
		String version = repository.getDescriptor(Repository.REP_VERSION_DESC);
		LOGGER.info("We Are Using " + vendor + " " + product + " version " + version);
		String user = session.getUserID(); 
		LOGGER.info("Logged in as " + user + " to a " + product + " repository.");
	}

}
