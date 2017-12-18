package com.tecsolvent.wizspeak.notification.main.test;

import static spark.Spark.*;

import java.util.List;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.services.NotificationLogicException;
import com.tecsolvent.wizspeak.notification.services.ViewNotificationService;
import com.tecsolvent.wizspeak.notification.services.ViewNotificationServiceImpl;

import spark.Request;
import spark.Response;
import spark.Route;

public class MainTestClass {
	
	public static void main(String[] args) {
	get("/hello", new Route() {
		@Override
		public Object handle(Request request, Response response) throws NotificationLogicException {
		// process request
			ViewNotificationService vns = new ViewNotificationServiceImpl();
			return vns.get(1234);
		}
		});
	}
	private static String createResponse() throws NotificationLogicException {
		//1234
		ViewNotificationService vns = new ViewNotificationServiceImpl();
			List<Notification> listOfNotification = vns.get(1234);
			System.out.println("listOfNotification size: " + listOfNotification.size());
		
		return "Hello World";
	}

}
