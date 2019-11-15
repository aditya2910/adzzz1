package com.om.poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.om.poc.dto.PersonDto;

public class App2 {

  public static void main(String[] args) throws IOException {

    App2 main = new App2();
    File file = main.getFileFromResources("person_request.json");

    String fileContent = getFileContent(file);

    PersonDto personDto = convertFileContentToPerson(fileContent);
    System.out.println(personDto);
  }

  private static PersonDto convertFileContentToPerson(final String fileContent) {
    PersonDto dto = null;
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
      mapper.configure(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL, true);
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
      mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
      mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);

      mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
      mapper.configure(MapperFeature.AUTO_DETECT_CREATORS, true);
      mapper.configure(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, true);
      mapper.configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, true);
      mapper.configure(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS, true);
      mapper.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
      mapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
      mapper.configure(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS, true);
      mapper.configure(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES, true);
      mapper.configure(MapperFeature.USE_STATIC_TYPING, true);
      mapper.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, true);
      mapper.configure(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL, true);

      mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);

      dto = mapper.readValue(fileContent, PersonDto.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dto;
  }

  private File getFileFromResources(String fileName) {

    ClassLoader classLoader = getClass().getClassLoader();

    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }

  }

  private static String getFileContent(File file) throws IOException {
    String lineStr = "";
    if (file == null) return null;

    try (FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader)) {

      String line;
      while ((line = br.readLine()) != null) {
        lineStr = lineStr + line;
      }
    }
    return lineStr;
  }
}
