package com.sb.service;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.qom.Column;
import javax.jcr.query.qom.Constraint;
import javax.jcr.query.qom.Literal;
import javax.jcr.query.qom.QueryObjectModelFactory;
import javax.jcr.query.qom.Selector;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.server.io.ZipHandler;

public class JRTest {

	public static void main(String[] args) throws Exception {

        Repository repository = JcrUtils.getRepository("http://localhost:9080/jackrabbit-webapp-2.16.3/server");

       

        Session session = null;

        try {
//        	session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
//
//            session.getWorkspace().createWorkspace("ABCD");
//            session.save();

            session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "ABCD");

            System.out.print(session.getWorkspace().getName());

            Node root = session.getRootNode();

            // Store content

           

            /*Node hello = root.addNode("hello");

            hello.setPrimaryType("nt:folder");

           

            Node world = hello.addNode("world1", "nt:file");

            Node contentNode = world.addNode("jcr:content", "nt:resource");*/

           

            Node hello = root.addNode("hello");      

            Node world = hello.addNode("world1");           

            Node contentNode = world.addNode("jcr:content");

           

            contentNode.setProperty ("jcr:mimeType", ZipHandler.ZIP_MIMETYPE);

            contentNode.setProperty ("jcr:data", "SimpleTestSearch");

            contentNode.addMixin("mix:title");

            contentNode.setProperty("jcr:title", "xslt");

            contentNode.setProperty("jcr:description", "xsltfile");

            contentNode.setProperty("data", "blahhhhhhh");

            contentNode.setProperty("name", "customName");

            contentNode.addMixin("mix:versionable");

            session.save();

           

            // Retrieve content

            Node node = root.getNode("hello/world1");

            NodeIterator allDataNodes = node.getNodes();

            Iterable<Node> itr = () -> allDataNodes;

            StreamSupport.stream(itr.spliterator(), true).forEach(dataNode -> {

                try {

                    System.out.println(((Node)dataNode).getPath());               

                    System.out.println(((Node)dataNode).getProperty("jcr:data").getValue().getString());

                    System.out.println(((Node)dataNode).getProperty("jcr:title").getString());

                    System.out.println(((Node)dataNode).getProperty("jcr:description").getString());     

                } catch (RepositoryException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }          

            });

            /*QueryManager queryManager = session.getWorkspace().getQueryManager();

            String query = "SELECT * FROM [mix:title] AS title WHERE CONTAINS([jcr:description], '*ltfi*')";

//            String query = "SELECT * FROM [mix:title] AS title WHERE title.[jcr:description] LIKE '%ltfi%'";

            Query q = queryManager.createQuery(query, Query.JCR_SQL2);           

            System.out.println(q.getStatement());

            QueryResult queryResult = (QueryResult) q.execute();

            Iterator iter1 = queryResult.getRows();

            iter1.forEachRemaining(nodeIter -> {

                System.out.println(nodeIter);

            });

            System.out.print("size : " + queryResult.getNodes().getSize());

            session.save();*/

           

            QueryManager queryManager = session.getWorkspace().getQueryManager();

            QueryObjectModelFactory factory = queryManager.getQOMFactory();

            Selector source = factory.selector("nt:base", "mixtitle");

            Column[] columnArr = new Column[3];

            columnArr[0] = factory.column("mixtitle", "data", "data");

            columnArr[1] = factory.column("mixtitle", "jcr:baseVersion", "version");

            columnArr[2] = factory.column("mixtitle", "jcr:path", "name");

            Value val = session.getValueFactory().createValue("*hhh*");

            Literal literal = factory.literal(val);

            Constraint constraint = factory.fullTextSearch(source.getSelectorName(), "data", literal);

//            Constraint constraintPath = factory.descendantNode("mixtitle", node.getParent().getParent().getPath());

            Constraint constraintPath = factory.descendantNode("mixtitle", node.getParent().getPath());

            /*PropertyValue propVal = factory.propertyValue("mixtitle", "jcr:score");

            Ordering jcrScoreOrder = factory.ascending(propVal);

            Ordering[] orders = {jcrScoreOrder};*/

            Query q = factory.createQuery(source, factory.and(constraint, constraintPath), null, null);

//            Query q = factory.createQuery(source, constraint, null, null);

            QueryResult queryResult = (QueryResult) q.execute();

           

            ////////////////////////////////////////

            /*QueryManager queryManager = session.getWorkspace().getQueryManager();

            QueryObjectModelFactory factory = queryManager.getQOMFactory();

            Selector source = factory.selector("nt:resource", "ntResource");

           

            Constraint constraints = factory.fullTextSearch(source.getSelectorName(), "jcr:data");*/

            Iterator<Node> iter = root.getNodes("hello");

            while(iter.hasNext()) {

                Node nodehello = iter.next();

                nodehello.remove();

            }

            session.save();

        } finally {

            session.logout();

        }

    }

}
