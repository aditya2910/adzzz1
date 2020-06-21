package com.poc.java.protectsingleton;

public class ReflectionSingletonProtect {

  public static void main(String[] args) {
    Resource a = Resource.getInstance();
    Resource b = Resource.getInstance();

    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
  }
}
