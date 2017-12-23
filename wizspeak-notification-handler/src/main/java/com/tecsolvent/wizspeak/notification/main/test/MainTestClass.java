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

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainTestClass {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
		get("/hello", new Route() {
			@Override
			public Object handle(Request request, Response response) throws NotificationLogicException {
				ViewNotificationService vns = ctx.getBean(ViewNotificationServiceImpl.class);
				System.out.println("vns: " + vns);
				vns.get(123L);
				return "Hello World";
			}
		});
	}

}
