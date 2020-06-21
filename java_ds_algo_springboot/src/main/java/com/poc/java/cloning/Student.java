package com.poc.java.cloning;

public class Student implements Cloneable{

  int id;
  String name;

  public Student(final int id, final String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();

  }
}
