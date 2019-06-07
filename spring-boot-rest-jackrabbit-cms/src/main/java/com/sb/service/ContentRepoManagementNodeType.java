package com.sb.service;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import javax.jcr.NamespaceRegistry;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PropertyType;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.nodetype.NodeTypeTemplate;
import javax.jcr.nodetype.PropertyDefinitionTemplate;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.qom.Constraint;
import javax.jcr.query.qom.QueryObjectModelFactory;
import javax.jcr.query.qom.Selector;
import javax.jcr.query.qom.Source;

import org.apache.jackrabbit.commons.JcrUtils;

public class ContentRepoManagementNodeType {
	
	private static final String PROP_KEY_1_VALUE = "prop_key_1_values";
	private static final String PROP_KEY_2_VALUE = "prop-key-1-values";
	private static final String PROP_KEY_3_VALUE = "prop-key-3-values";
	private static final String PROP_KEY_1 = "prop-key-1";
	private static final String PROP_KEY_3 = "prop-key-3";
	private static final String OM_TEST_NODE_TYPE = "om:testNodeType";
	private static final String JR_REPO_WITH_NODETYPE = "test-nodetype-repo";
	
	public static void main(String[] args) {
		//createRepositotyInJR(JR_REPO_WITH_NODETYPE);
		
		Session session = getSessionOfAboveCreatedWorkSpace(JR_REPO_WITH_NODETYPE);
		
		//deleteRepository(session);
		
		//registerSomeNodeTypes(session);
		//System.out.println("node types registered");
		//createWorkspaceWithNodeType(session);
		
		savePropertyToGivenNode(session, "test-nodetype-repo/node-1", PROP_KEY_3, PROP_KEY_3_VALUE);
		System.out.println("I am done creating ");
		
		//getPropertyDataFromNode_fullTextSearch(session);
		
	}

	
	private static void savePropertyToGivenNode(Session session, String nodePath, String propKey, String propKeyValue) {
		try {
			Node n = session.getRootNode().getNode(nodePath); 
			n.setProperty(propKey, propKeyValue);
			System.out.println(n);
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}


	private static void getPropertyDataFromNode_fullTextSearch(Session session) {
		// SELECT * FROM [nt:base] AS ntbase WHERE CONTAINS(ntbase.STYLE, '*a*') AND ISDESCENDANTNODE(ntbase, [/DEV/US/CREDITCARD/SYSTEMADMIN/SEARCHANDPREFILLCONFIG])

		Query query = getQueryToFetchResultFromJR_fullTextSearch(PROP_KEY_1, PROP_KEY_1_VALUE, session);
		System.out.println(query);

		try {
			NodeIterator nodeItr = query.execute().getNodes();
			System.out.println("nodes soze: " + nodeItr.getSize());
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			session.logout();
		}
		
	}
	
	
	
	

	private static Query getQueryToFetchResultFromJR_fullTextSearch(String propKey1, String propKey1Value, Session session) {
		Query query = null;
		try {
			final QueryManager queryManager = session.getWorkspace().getQueryManager();
			final QueryObjectModelFactory factory = queryManager.getQOMFactory();
			//final Source selector = factory.selector("om:abc", "omabc");
			final Selector source = factory.selector("om:abc", "omabc");
			final Constraint constraints = factory.fullTextSearch(source.getSelectorName(), null, factory.literal(session.getValueFactory().createValue(PROP_KEY_1_VALUE)));
			query = factory.createQuery(source, constraints, null, null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return query;
	}

	private static void createWorkspaceWithNodeType(Session session) {
		try {
			Node root = session.getRootNode();
			Node node1 = root.addNode("node-1", "om:abc");
			node1.setProperty(PROP_KEY_1, PROP_KEY_1_VALUE);
			session.save();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void deleteRepository(Session session) {
		//test-nodetype-repo
		try {
			Node root = session.getRootNode(); 
			root.getNode(JR_REPO_WITH_NODETYPE).remove(); 
			session.save();
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		} 
	}


	


	private static void registerSomeNodeTypes(Session session) {
		try {
			NodeTypeManager manager = (NodeTypeManager) session.getWorkspace().getNodeTypeManager();
			//NamespaceRegistry ns = session.getWorkspace().getNamespaceRegistry();
			
			NodeTypeTemplate nodeTypeTemplate = manager.createNodeTypeTemplate();
			//nodeTypeTemplate.setName(OM_TEST_NODE_TYPE);
			
			
			NamespaceRegistry namespaceRegistry = session.getWorkspace().getNamespaceRegistry();
			namespaceRegistry.registerNamespace("om", "http://fico.com/om");
			PropertyDefinitionTemplate propDefTemplateNodeIdentifier = manager.createPropertyDefinitionTemplate();
			propDefTemplateNodeIdentifier.setName(String.join(":", "om", 
					"nodeidentifier"));
			propDefTemplateNodeIdentifier.setRequiredType(PropertyType.STRING);
			PropertyDefinitionTemplate propDefTemplateNodeData = manager.createPropertyDefinitionTemplate();
			propDefTemplateNodeData.setName(String.join(":", "om", 
					"nodedata"));
			propDefTemplateNodeData.setRequiredType(PropertyType.STRING);
			nodeTypeTemplate.getPropertyDefinitionTemplates().add(propDefTemplateNodeIdentifier);
			nodeTypeTemplate.getPropertyDefinitionTemplates().add(propDefTemplateNodeData);
			String parentNodeTypes[] = {"nt:unstructured", "mix:referenceable"};
			nodeTypeTemplate.setDeclaredSuperTypeNames(parentNodeTypes);
			
			
			nodeTypeTemplate.setName("om:abc");
			manager.registerNodeType(nodeTypeTemplate, true);
			
			 session.save();
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

	}


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
			
		}
		System.out.println("Repo created success");
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
	private static void saveSessionOfJR(Session session) {
		try {
			session.save();
			session.logout();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
}
