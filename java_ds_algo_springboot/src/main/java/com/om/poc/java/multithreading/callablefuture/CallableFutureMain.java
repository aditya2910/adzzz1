package com.om.poc.java.multithreading.callablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureMain {

  public static void main(String[] args) {
    Callable myCallable = () -> {
      return 1;
    };

    List<Future<Integer>> list = new ArrayList<>();
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
      Future<Integer> response =executor.submit(myCallable);
      list.add(response);
    }
    System.out.println(list);
  }

}

