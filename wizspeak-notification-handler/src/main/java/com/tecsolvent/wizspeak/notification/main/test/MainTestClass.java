package com.tecsolvent.wizspeak.notification.main.test;

import static spark.Spark.*;

public class MainTestClass {
	
	public static void main(String[] args) {
		System.out.println("Waiting for requests.....");
        get("/hello", (req, res) -> createResponse());
    }

	private static String createResponse() {
		return "Hello World";
	}

}
