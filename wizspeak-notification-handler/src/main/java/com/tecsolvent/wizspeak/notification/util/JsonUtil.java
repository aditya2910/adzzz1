package com.tecsolvent.wizspeak.notification.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vikash Kumar
 *
 */
public class JsonUtil {
	
	/**
	 * @param obj, object to be converted in json string.
	 * @return json string.
	 * @throws JsonProcessingException
	 */
	public static String getJson(Object obj) throws JsonProcessingException {
		String jsonStr = "";
		ObjectMapper mapper = new ObjectMapper();
		if (obj != null) {
			jsonStr = mapper.writeValueAsString(obj);
		}
		return jsonStr;
	}
	
	/**
	 * @param jsonStr, json string
	 * @return node corresponding to json string.
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode getJson(String jsonStr) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readTree(jsonStr);
	}
}
