package com.om.poc.java.sorting;

public class Student implements Comparable<Student> {

  int id;
  String name;
  int age;

  public Student(final int id, final String name, final int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(final Student student) {
    if(id == student.id) {
      return 0;
    } else if(id > student.id) {
      return 1;
    } else {
      return -1;
    }
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
  }
}
