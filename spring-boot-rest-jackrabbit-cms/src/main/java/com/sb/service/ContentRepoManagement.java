package com.sb.service;

import java.util.stream.StreamSupport;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.qom.QueryObjectModelFactory;
import javax.jcr.query.qom.Selector;

import org.apache.jackrabbit.commons.JcrUtils;

public class ContentRepoManagement {
	
	private static final String PROPERTY1_VALUE = "blah blah";
	private static final String PROPERTY1_KEY = "data";
	private static final String NODE3 = "jcr:content";
	private static final String NODE2 = "world1";
	private static final String NODE1 = "hello";
	private static final String REPO_WS1 = "test-ws1";
	private static final String JR_REPO = "test-repo";
	private static final String SLASH = "/";

	public static void main(String[] args) {
		//createRepositotyInJR(JR_REPO);
		
		Session session = getSessionOfAboveCreatedWorkSpace(JR_REPO);
		//create2NodesAndSaveContent(session);
		//saveSessionOfJR(session);
		
		//printContentOfAboveSavedContentInItsNodes_iterateOverNodes(session, NODE1 + SLASH + NODE2);
		
		//deleteCompleteNode(session, NODE1);
		
		searchForGivenTextInGivenNode(PROPERTY1_KEY, PROPERTY1_VALUE, session);
		
		session.logout();
	}


	private static void searchForGivenTextInGivenNode(String propertyKey, String propertyValue, Session session) {
		Query query = getQueryToFetchResultFromJR(propertyKey, propertyValue, session);
		System.out.println(query);
		QueryResult queryResult = null;
		try {
			queryResult = query.execute();
			System.out.println(queryResult);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		printQueryResult(queryResult);
	}


	private static void printQueryResult(QueryResult queryResult) {
		NodeIterator allDataNodes;
		Iterable<Node> itr = null;
		try {
			allDataNodes = queryResult.getNodes();
			itr = () -> allDataNodes;
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
		
		StreamSupport.stream(itr.spliterator(), true).forEach(dataNode -> {
			try {
				String nodeName = dataNode.getName();
				if (dataNode.hasProperty("data")) {
					//System.out.println(" nodeName = " + dataNode.getName());
					//System.out.println(((Node) dataNode).getProperty(PROPERTY1_KEY).getValue().getString());
					String value = ((Node) dataNode).getProperty(PROPERTY1_KEY).getValue().getString();
					if (value.contains("blah"))
						System.out.println(" *********************************************************************************************value = " + value);
				}
			} catch (Exception excep) {
				excep.printStackTrace();
			}
		});
	}


	private static Query getQueryToFetchResultFromJR(String propertyKey, String propertyValue, Session session) {
		QueryManager queryManager;
		try {
			queryManager = session.getWorkspace().getQueryManager();
			QueryObjectModelFactory factory = queryManager.getQOMFactory();
			
			Selector source = factory.selector("nt:base", "ntbase");
			Query query = factory.createQuery(source, null, null, null);
			
			return query;
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}


	private static void deleteCompleteNode(Session session, String node1) {
		try {
			Node root = session.getRootNode();
			root.getNode(node1).remove(); 
			session.save();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}


	private static void printContentOfAboveSavedContentInItsNodes_iterateOverNodes(Session session, String pathOfNode) {
		try {
			Node root = session.getRootNode();
			Node node = root.getNode(pathOfNode);
			NodeIterator allDataNodes = node.getNodes();
			Iterable<Node> itr = () -> allDataNodes;
			StreamSupport.stream(itr.spliterator(), true).forEach(dataNode -> {

				try {
					System.out.println(((Node) dataNode).getPath());
					System.out.println(((Node) dataNode).getProperty(PROPERTY1_KEY).getValue().getString());
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
			});
			System.out.println("Above is one approach");
			
			Node node_ = root.getNode(pathOfNode + SLASH + NODE3); 
            System.out.println(node_.getPath()); 
            System.out.println(node_.getProperty(PROPERTY1_KEY).getString()); 
            System.out.println("Above is second approach");
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}


	private static void create2NodesAndSaveContent(Session session) {
		try {
			Node root = session.getRootNode();
			Node hello = root.addNode(NODE1);
			Node world = hello.addNode(NODE2); 
			Node contentNode = world.addNode(NODE3);
			contentNode.setProperty(PROPERTY1_KEY, PROPERTY1_VALUE);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}


	private static Session getSessionOfAboveCreatedWorkSpace(String jrRepo) {

		try {
			Repository repository = JcrUtils.getRepository("http://localhost:9080/jackrabbit-webapp-2.16.3/server");
			return repository.login(new SimpleCredentials("admin", "admin".toCharArray()), jrRepo);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;

	}


	/**
	 * use this method only once while creating repo.
	 * this repo is same as a workspace
	 * @param repoName
	 */
	private static void createRepositotyInJR(String repoName) {
		Session session = null;
		try {
			Repository repository = JcrUtils.getRepository("http://localhost:9080/jackrabbit-webapp-2.16.3/server");
			session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
			session.getWorkspace().createWorkspace(repoName);
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			saveSessionOfJR(session);
			//session.logout();
		}
		
		// url of created repo - http://localhost:9080/jackrabbit-webapp-2.16.3/repository/test-repo
		// all repo in JR is seen at - http://localhost:9080/jackrabbit-webapp-2.16.3/server
		System.out.println("Repo created success");
	}


	private static void saveSessionOfJR(Session session) {
		try {
			session.save();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
