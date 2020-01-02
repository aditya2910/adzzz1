package com.om.poc.java.queue;

public class EmployeeNoComparable {

  private int id;
  private String name;
  private String dept;
  private double salary;

  public EmployeeNoComparable(final int id, final String name, final String dept, final double salary) {
    this.id = id;
    this.name = name;
    this.dept = dept;
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(final String dept) {
    this.dept = dept;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(final double salary) {
    this.salary = salary;
  }
}
