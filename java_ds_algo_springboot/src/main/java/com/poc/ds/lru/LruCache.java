package com.poc.ds.lru;

import java.util.HashMap;

public class LruCache {

  HashMap<Integer, Entry> hashmap;
  Entry start, end;
  int LRU_SIZE = 4; // Here i am setting 4 to test the LRU cache implementation, it can make be dynamic

  public LruCache() {
    hashmap = new HashMap<Integer, Entry>();
  }

  void putEntry(final int key, final int value) {

  }

  static synchronized void  m1() {
    Thread.currentThread().isInterrupted();
  }
}
