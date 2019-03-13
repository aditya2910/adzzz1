package com.test.ignite.task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.ignite.IgniteException;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.compute.ComputeJob;
import org.apache.ignite.compute.ComputeJobAdapter;
import org.apache.ignite.compute.ComputeJobResult;
import org.apache.ignite.compute.ComputeTaskAdapter;
import org.apache.ignite.compute.ComputeTaskName;
import org.apache.ignite.resources.SpringApplicationContextResource;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@ComputeTaskName("task1")
public class Task1 extends ComputeTaskAdapter<String, Object> {
	
//	@Autowired
//	RestTemplate restTemplate;
//	
//	@Autowired
//	private HelloBean helloBean;
	
	@SpringApplicationContextResource
	private ApplicationContext ctx;

	
	@Override
	public Map<? extends ComputeJob, ClusterNode> map(List<ClusterNode> nodes, String arg) throws IgniteException {
		System.out.println(".....inside Task1 map....  ");
		RestTemplate restTemplate = ctx.getBean(RestTemplate.class);
		System.out.println(".....inside Task1 map.... restTemplate: "+ restTemplate);
        System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
        
        
        ZipkinSpanReporter zipkinSpanReporter = ctx.getBean(ZipkinSpanReporter.class);
		System.out.println(".....inside Task1 map.... zipkinSpanReporter: "+ zipkinSpanReporter);

		
//		restTemplate = new RestTemplateBuilder()
//        .additionalInterceptors(TracingClientHttpRequestInterceptor.create(tracing))
//        .build();
		
		System.out.println(".....inside Task1 map.... restTemplate: "+ restTemplate);
		
		String response = (String) restTemplate.exchange("http://localhost:6083/bootelkzipkin3", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	      }).getBody();
			
			System.out.println("boot elk response: " + response);
		
		
		Map<ComputeJob, ClusterNode> map = new HashMap<ComputeJob, ClusterNode>();

        Iterator<ClusterNode> it = nodes.iterator();
            while(it.hasNext()) {
            	ClusterNode node = it.next();
	            try {
						
					map.put(new ComputeJobAdapter() {
					    @Nullable 
					    @Override 
					    public Object execute() {
					    	String applicationNumber = "test-app-no";
							System.out.println(".....generated application number : {} "+applicationNumber );
							
							
							
							return applicationNumber;
	
					    }
					}, node);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
            
            }

       return map;
	}

	@Override
	public Object reduce(List<ComputeJobResult> results) throws IgniteException {
		System.out.println(".......inside task of Task1....reduce()");
		return results.get(0).getData();
	}

	

}
