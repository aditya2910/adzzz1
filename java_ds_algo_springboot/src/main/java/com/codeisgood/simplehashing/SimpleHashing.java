package com.codeisgood.simplehashing;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class SimpleHashing {

  private Employee[] hashtable;

  public SimpleHashing() {
    hashtable = new Employee[10];
  }



  private int hashFunction(String key) {
    return key.length() % hashtable.length;
  }

  void put(final String key, final Employee employee) {
    int hashIndex = hashFunction(key);

    if(hashtable[hashIndex] != null) {
      System.out.println("Colloision has occured at index: " + hashIndex + " key: " + key) ;
    } else {
      hashtable[hashIndex] = employee;
    }

  }

  void printHashTable() {
    Arrays.stream(hashtable).forEach(System.out::println);
  }

  Employee get(final String key) {
    int hashIndex = hashFunction(key);
    return hashtable[hashIndex];
  }
}
