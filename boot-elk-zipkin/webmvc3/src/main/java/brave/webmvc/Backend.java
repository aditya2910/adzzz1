package brave.webmvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class Backend {
	
	@Autowired
	RestTemplate restTemplate;


	@RequestMapping("/api")
	public ResponseEntity<String> printDate(@RequestHeader(value = "user-name", required = false) String username) {
		
		System.out.println("............. I am in api");
		String result;
		if (username != null) {
			result = new Date().toString() + " " + username;
		} else {
			result = new Date().toString();
		}
		
//		String response = (String) restTemplate.exchange("http://localhost:6083/bootelkzipkin3", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
//        }).getBody();
//		
//		System.out.println("boot elk response: " + response);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
