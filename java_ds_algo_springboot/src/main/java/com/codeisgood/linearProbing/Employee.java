package com.codeisgood.linearProbing;

public class Employee {

  private int id;
  private String fname;
  private String lname;

  public Employee(final int id, final String fname, final String lname) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
  }

  public int getId() {
    return id;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + id + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + '}';
  }
}
