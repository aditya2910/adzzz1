package com.poc.deleteme2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample extends Object{

  static Lock lock = new ReentrantLock();
  Object resource = new Object();

  public static void main(String[] args) {


  }

  private static void databaseWork() {
    // big

  }
}
