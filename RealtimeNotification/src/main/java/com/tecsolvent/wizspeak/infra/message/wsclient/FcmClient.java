package com.tecsolvent.wizspeak.infra.message.wsclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class FcmClient {

	public static void main(String[] args) {
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("https://fcm.googleapis.com/fcm/send");
			postRequest.setHeader("Content-Type", "application/json");
			postRequest.setHeader("Authorization", "key=AAAA_S_oYxc:APA91bGN0BJj-iwjmy3TA75gDkmeJwP11raN60FsK8fpvncOj-Xng6abaEmc-fJfRgJOaGKzJSFjPY4dnD8XxK8RCabJ7wkSa51Jadq53AoO_J39Zze0ofI4WJijVmXgix9oF9mU2nnS");
				
			String FILENAME = "C:\\workspaces\\eclipse-luna\\RealtimeNotification\\src\\main\\resources\\request.json";
			StringBuilder contentBuilder = new StringBuilder();
			 
	        try (Stream<String> stream = Files.lines( Paths.get(FILENAME), StandardCharsets.UTF_8))
	        {
	            stream.forEach(s -> contentBuilder.append(s).append("\n"));
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
			
			StringEntity input = new StringEntity(contentBuilder.toString(), ContentType.create("application/json"));
				//input.setContentType("application/json");
				postRequest.setEntity(input);

				HttpResponse response = httpClient.execute(postRequest);
				System.out.println("Response: " + response.getStatusLine().getStatusCode());
				
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
