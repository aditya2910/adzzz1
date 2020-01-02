package com.om.poc.java.multithreading.completablefutute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {

  public static void main(String[] args) {
    long started = System.currentTimeMillis();

    CompletableFuture<Integer> futureCount = createCompletableFuture();

    try {
      int count = futureCount.get();
      System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );

      System.out.println("Result " + count);
    } catch (InterruptedException | ExecutionException ex) {
        ex.printStackTrace();
    }
  }

  private static CompletableFuture<Integer> createCompletableFuture() {
    CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
        () -> {
          try {
            // simulate long running task
            Thread.sleep(5000);
          } catch (InterruptedException e) { }
          return 20;
        });
    return futureCount;

  }
}
