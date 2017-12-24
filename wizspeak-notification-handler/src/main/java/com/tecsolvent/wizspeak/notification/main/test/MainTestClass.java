package com.tecsolvent.wizspeak.notification.main.test;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.services.NotificationLogicException;
import com.tecsolvent.wizspeak.notification.services.NotificationService;
import com.tecsolvent.wizspeak.notification.services.NotificationServiceImpl;
import com.tecsolvent.wizspeak.notification.services.ViewNotificationService;
import com.tecsolvent.wizspeak.notification.services.ViewNotificationServiceImpl;
import com.tecsolvent.wizspeak.notification.upstream.handler.impl.WizspeakUpstreamHandler;
import com.tecsolvent.wizspeak.notification.util.JsonUtil;

import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;


public class MainTestClass {
	
	public static void main(String[] args) {
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");		
		final WizspeakUpstreamHandler upstreamHandler = ctx.getBean(WizspeakUpstreamHandler.class);
		final ViewNotificationService vns = ctx.getBean(ViewNotificationServiceImpl.class);
		
		Map<String, String> msgContainer = new HashMap<String, String>();
		long userId = 1234L;
		long actorId = 2345L;
		long postId = 3456L;
		upstreamHandler.sendNotification(userId, Category.TEAMS, actorId, postId, Type.COMMENT, msgContainer, true);
		upstreamHandler.sendNotification(userId, Category.TEAMS, 234566L, postId, Type.COMMENT, msgContainer, true);
		
		get("/notifications/:userId", new Route() {
			
			public Object handle(Request request, Response response) throws NotificationLogicException, JsonProcessingException {
				
				List<Notification> notifications = vns.get(Long.parseLong(request.params(":userId")));
				
				Map<String, Object> result = new HashMap<String, Object>();
				
				List<Notification> ambitions = new ArrayList<Notification>();
				List<Notification> hobbies = new ArrayList<Notification>();
				List<Notification> team = new ArrayList<Notification>();
				
				for (Notification notification : notifications) {
					switch(notification.getCategory()) {
					case AMBITION:
						ambitions.add(notification);
						break;
					case HOBBIES:
						hobbies.add(notification);
						break;
					case TEAMS:
						team.add(notification);
						break;
					default:
						break;
					
					}
				}
				
				NotificationResponse ambitionResponse = new NotificationResponse(ambitions.size(), ambitions);
				NotificationResponse hobbiesResponse = new NotificationResponse(hobbies.size(), hobbies);
				NotificationResponse teamResponse = new NotificationResponse(team.size(), team);
				
				result.put("count", notifications.size());
				result.put("Ambition", ambitionResponse);
				result.put("Hobbies", hobbiesResponse);
				result.put("Team", teamResponse);
				
				
				return JsonUtil.getJson(result);
			}
		});
		
		post("/notifications", new Route() {
			
			public Object handle(Request request, Response response) throws NotificationLogicException, JsonProcessingException, IOException {
				JsonNode bodyParams = JsonUtil.getJson(request.body());
				 
				long userId = bodyParams.get("userId").asLong();
				long actorId = bodyParams.get("actorId").asLong();
				long postId = bodyParams.get(("postId")).asLong();
				Map<String, String> msgContainer = new HashMap<String, String>();
				
				upstreamHandler.sendNotification(userId, Category.TEAMS, actorId, postId, Type.COMMENT, msgContainer, true);
				response.status(201);
				return response;
			}
		});
		
		put("/notifications/:notificationId", new Route() {
			
			public Object handle(Request request, Response response) throws NotificationLogicException, JsonProcessingException, IOException {				 
				String notificationId = request.params("notificationId");
				
				vns.updateStatus(notificationId, Notification.Status.READ);
				response.status(200);
				return "";
			}
		});
	}
	
	

}


class NotificationResponse {
	private long count = 0;
	private List<Notification> notifications = new ArrayList<Notification>();
	
	public NotificationResponse (long count, List<Notification> notifications) {
		this.count = count;
		this.notifications = notifications;
	}
	
	public long getCount() {
		return count;
	} 
	
	public  List<Notification> getNotifications() {
		return notifications;
	}
}