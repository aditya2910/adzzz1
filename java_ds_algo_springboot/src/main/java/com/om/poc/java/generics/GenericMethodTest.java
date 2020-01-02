package com.om.poc.java.generics;

public class GenericMethodTest {

  public static void main(String[] args) {
    ServiceImpl service = new ServiceImpl();

    Employee emp = new Employee();
    Employee emp2 = (Employee)service.getObj(emp);
    System.out.println(emp.equals(emp2));


    Student student = new Student();
    Student student2 = (Student)service.getObj(student);
    System.out.println(student.equals(student2));
  }
}
