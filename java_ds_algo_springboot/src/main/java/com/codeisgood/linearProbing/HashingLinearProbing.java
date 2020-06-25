package com.codeisgood.linearProbing;

import java.util.Arrays;

public class HashingLinearProbing {

  private StoredEmployee[] hashtable;

  public HashingLinearProbing() {
    hashtable = new StoredEmployee[5];
  }

  public void put(String key, Employee employee) {
    int hashIndex = hashfunction(key);

    int stopIndex = 0;
    if (occupiedIndex(hashIndex)) {
      if(hashIndex == hashtable.length -1) {
        hashIndex = 0;
      }

      if (occupiedIndex(hashIndex)) {
        while (occupiedIndex(hashIndex) && stopIndex < hashtable.length) {
          hashIndex++;
          stopIndex++;
          if(stopIndex == hashtable.length){
            break;
          }
          if(hashIndex == hashtable.length) {
            hashIndex = 0;
          }
        }
      }
    }

    if(stopIndex == hashtable.length) {
      System.out.println("hashtable is full");
    } else {
      hashtable[hashIndex] = new StoredEmployee(key, employee);
    }
  }

  private boolean occupiedIndex(final int hashIndex) {
    return hashtable[hashIndex] != null;
  }

  private int hashfunction(String key) {
    return key.length() % hashtable.length;
  }

  void printHashTable() {
    Arrays.stream(hashtable).forEach(System.out::println);
  }

  public Employee get(final String key) {
    int hashIndex = hashfunction(key);
    if(hashtable[hashIndex].key.equals(key)) {
      return hashtable[hashIndex].employee;
    } else {
      int stopIndex = 0;
      while (!hashtable[hashIndex].key.equals(key)) {
        if(stopIndex == hashtable.length) {
          break;
        }
        if(hashIndex == hashtable.length -1) {
          hashIndex = 0;
        }
        hashIndex++;
        stopIndex++;
      }
    }
    // check key
    if(hashtable[hashIndex].key.equals(key)) {
      return hashtable[hashIndex].employee;
    }
    return null;
  }
}
