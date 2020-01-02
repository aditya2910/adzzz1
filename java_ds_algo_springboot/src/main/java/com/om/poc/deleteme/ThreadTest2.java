package com.om.poc.deleteme;

import java.util.Random;

public class ThreadTest2 {

  public static void main(String[] args) {
    Random random = new Random(100);


    for (int i = 0; i < 10; i++) {
      Runnable runnable  = new MyTask(random.nextInt());
      Thread thread = new Thread(runnable);
      thread.setPriority(10-i);
      //thread.start();
      thread.run();
    }

  }
}
