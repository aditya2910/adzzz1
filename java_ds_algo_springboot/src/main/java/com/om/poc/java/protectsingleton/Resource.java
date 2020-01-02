package com.om.poc.java.protectsingleton;

import java.io.Serializable;

public class Resource implements Serializable{

  private static final Resource INSTANCE = new Resource();

  private Resource() {
    if (INSTANCE != null) {
      throw new IllegalStateException("Inside JavaSingleton(): JavaSingleton " +
          "instance already created.");
    }
    System.out.println("Inside JavaSingleton(): Singleton instance is being created.");
  }

  public static final Resource getInstance() {
    return INSTANCE;
  }

  public void askQuestion() {
    System.out.println("Hello. Are you able to protect me from Reflection ?");
  }
}
