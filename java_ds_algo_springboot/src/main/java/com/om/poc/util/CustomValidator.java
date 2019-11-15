package com.om.poc.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomValidator extends StdDeserializer<Date> {

  public CustomValidator() {
    this(null);
  }

  public CustomValidator( Class<?> clazz) {
    super(clazz);
  }


  @Override
  public Date deserialize(final JsonParser jp, final DeserializationContext ctxt)
      throws IOException, JsonProcessingException {

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);

    final String birthDateContent = node.get("birthdate").asText();


    return new Date();
  }


}
