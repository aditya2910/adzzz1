package com.poc.java.generics;


/**
 * https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/
 */
public class ServiceImpl {

  public <T> Object getObj(T obj) {

    if(obj instanceof Employee) {
      System.out.println("Got EmployeeNoComparable");
      return (Employee)obj;
    } else if(obj instanceof Student) {
      System.out.println("Got Student");
      return (Student)obj;
    }

    return null;
  }
}
