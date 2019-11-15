package com.om.poc.java.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "John", 25));
    students.add(new Student(5, "bar", 30));
    students.add(new Student(2, "foo", 28));

    System.out.println("initial students: " + students);

    Collections.sort(students);
    System.out.println("final students: " + students);
  }
}
