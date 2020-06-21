package com.poc.java.cloning;

public class StudentBehavior {

  public static void main(String[] args) {
    Student s1 = new Student(1, "ABC");
    System.out.println("s1: " + s1);
    try {
      System.out.println("s2: " + s1.clone());
    } catch (CloneNotSupportedException cns) {
      cns.printStackTrace();
    }
  }
}
