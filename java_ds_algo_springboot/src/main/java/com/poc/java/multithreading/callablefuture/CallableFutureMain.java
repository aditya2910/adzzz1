package com.poc.java.multithreading.callablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import sun.jvm.hotspot.runtime.ResultTypeFinder;

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

    System.out.println("callable without pool");

    //Since there is no constructor Thread(Callable) using a Callable with a Thread without an ExecutorService requires slightly more code:

    FutureTask<ResultTypeFinder> futureTask = new FutureTask<>(myCallable);
    Thread t=new Thread(futureTask);
    t.start();

    try {
      ResultTypeFinder result = futureTask.get();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }

}

