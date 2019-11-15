package com.om.poc.jsonutil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONToMap {

  public static void main(String args[])
  {
    String str = "cerce[]everv[]";
    System.out.println(str.replace("[]", "[ ]"));

  }

  private static String getJsonString() {
    return "{\n" + "  \"testArrayKey1\": [\n" + "    {\n" + "      \"PersonalId\": \"1111\",\n"
        + "      \"testArrayKey1\": \"ValueToBeReplaced1\"\n" + "    },\n" + "    {\n"
        + "      \"PersonalId\": \"1112\",\n" + "      \"testArrayKey1\": \"ValueToBeReplaced2\"\n" + "    },\n"
        + "    {\n" + "      \"appendFlag\": \"true\",\n" + "      \"fields\": [\n" + "        \"PersonalId\"\n"
        + "      ]\n" + "    },\n" + "    {\n" + "      \"PersonalId\": \"1111\",\n"
        + "      \"testArrayKey1\": \"testArrayValue1\"\n" + "    },\n" + "    {\n"
        + "      \"PersonalId\": \"1112\",\n" + "      \"testArrayKey1\": \"testArrayValue2\"\n" + "    }\n"
        + "  ],\n" + "  \"testKey2\": \"testValue2\",\n" + "  \"testKey1\": \"testValue1\",\n"
        + "  \"testKey4\": \"testValue4\",\n" + "  \"testKey3\": {\n"
        + "    \"testChildKey3\": \"testChildValue3\",\n" + "    \"testChildKey1\": \"testChildValue1\",\n"
        + "    \"testChildKey2\": \"testChildValue2\"\n" + "  },\n" + "  \"testKey6\": \"testValue6\",\n"
        + "  \"testKey5\": [\n" + "    \"testArrValue1\",\n" + "    \"testArrValue2\",\n" + "    \"testArrValue3\",\n"
        + "    \"testArrValue4\",\n" + "    \"testArrValue5\"\n" + "  ]\n" + "}";
  }
}
