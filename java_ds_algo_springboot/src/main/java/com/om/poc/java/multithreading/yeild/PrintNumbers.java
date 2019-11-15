package com.om.poc.java.multithreading.yeild;

import java.util.stream.IntStream;

public class PrintNumbers {

  public static void main(String[] args) throws InterruptedException{

    int initialNo = 0;
    int lastNo = 100;

    Runnable oddTask = () -> {
      for (int i = initialNo; i < lastNo; i++) {
        if(i % 2 != 0) {
          System.out.println(i);
          //Thread.yield();
        }
      }
    };

    Runnable evenTask = () -> {
      for (int i = initialNo; i < lastNo; i++) {
        if(i % 2 == 0) {
          System.out.println(i);
          //Thread.yield();
          //System.out.println(Thread.interrupted());
        }
      }
    };

    Thread oddThread = new Thread(oddTask);
    Thread evenThread = new Thread(evenTask);

    evenThread.start();
    evenThread.interrupt();
    oddThread.start();



    //evenThread.interrupt();
  }
}
