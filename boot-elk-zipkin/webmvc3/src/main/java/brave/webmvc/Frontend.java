package brave.webmvc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

@Controller
public class Frontend {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    ApplicationContext applicationContext;

	@RequestMapping("/")
	public ResponseEntity<String> callBackend() {
		System.out.println("............. I am in default");
		//String result = template.getForObject("http://localhost:9000/api", String.class);
		
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
		
		String response = (String) restTemplate.exchange("http://localhost:6083/bootelkzipkin3", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
      }).getBody();
		
		System.out.println("boot elk response: " + response);
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
