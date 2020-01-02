package com.om.poc.deleteme;


public class RefTest {

  public static void main(String[] args) {

    String s = "a";
    changIt(s);
    System.out.println("main: " + s);

    Model1 model1 = new Model1("adi");
    changIt(model1);
    System.out.println("main: " + model1.getName());
  }

  private static void changIt(final Model1 model1) {
    model1.setName("pri");
    System.out.println("changIt: " + model1.getName());
  }

  private static void changIt(String s) {
    s= "b";
    System.out.println("changIt: " + s);
  }
}

