package com.sb.service;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;

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
			//Repository repository = JcrUtils.getRepository();
			Repository repository = JcrUtils.getRepository("http://localhost:9080/jackrabbit-webapp-2.16.3/server");
			//session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
			session = repository.login(new SimpleCredentials("admin","admin".toCharArray()));
//			session = repository.login(new SimpleCredentials("admin","admin".toCharArray()), "new_repo1");

			Workspace workspace = session.getWorkspace();
			workspace.createWorkspace("new_repo");
			session.save();
//			logDescrioptionOfRepositoryAndSession(repository, session);
//
//			System.out.println("I am readty for store and retrieve content from JR");
//			
//			storeContentToJR(content, repository, session);
			
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			session.logout();
		}

	}

	private void storeContentToJR(String content, Repository repository, Session session) {
		try { 
            Node root = session.getRootNode(); 
            System.out.println("root node: " + root.getName());
            
//            Workspace workspace = session.getWorkspace();
//			workspace.createWorkspace("new_ws1");
//			System.out.println("workspace: " + workspace.getName());
//			session.save();
            
            // Store content 
            Node hello = root.addNode("hello"); 
            Node world = hello.addNode("world"); 
            world.setProperty("message", "Hello, World!"); 
            session.save(); 
            System.out.println("Store to JR is success");

            // Retrieve content 
            Node node = root.getNode("hello/world"); 
            System.out.println(node.getPath()); 
            System.out.println(node.getProperty("message").getString()); 

            // Remove content 
//            root.getNode("hello").remove(); 
//            session.save(); 
        } catch (RepositoryException e) {
			e.printStackTrace();
		} 
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
