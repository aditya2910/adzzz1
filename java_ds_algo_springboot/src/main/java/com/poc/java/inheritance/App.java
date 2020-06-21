package com.poc.java.inheritance;

public class App {

  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.makeNoise();
    dog.fetch();
    dog.move();
    dog.wagTail();

    Canine canine = new Dog();
    canine.makeNoise();
    //canine.fetch();
    canine.move();
    canine.wagTail();

    Animal animal = new Dog();
    animal.makeNoise();
    //animal.fetch();
    animal.move();
    //animal.wagTail();
  }
}
