package com.poc.java.hackvault;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  private static final int MAX_PWD = 9999;

  private static class Vault {
    private int password;

    public Vault(int password) {
      this.password = password;
    }

    public boolean isCorrectPassword(int guess) {
      try {
        // random password guessing/calculatin time
        Thread.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return this.password == guess;
    }
  }

  private static abstract class HackeereThread extends Thread {
    protected Vault vault;
    public HackeereThread(Vault vault) {
      this.vault = vault;
      this.setName(this.getClass().getSimpleName());
      this.setPriority(Thread.MAX_PRIORITY);
    }

//    @Override
//    public void start() {
//      System.out.println("Starting thread " + this.getName());
//      super.start();
//    }
  }

  private static class AscendingHackerThread extends HackeereThread {

    public AscendingHackerThread(Vault vault) {
      super(vault);
    }

    @Override
    public void run() {
      for (int guess = 0; guess < MAX_PWD; guess++) {
        if(vault.isCorrectPassword(guess)) {
          System.out.println(this.getName() + " guessed right");
          System.exit(0);
        }
      }
    }
  }

  private static class DescendingHackerThread extends HackeereThread {

    public DescendingHackerThread(Vault vault) {
      super(vault);
    }

    @Override
    public void run() {
      for (int guess = MAX_PWD; guess >= 0; guess--) {
        if(vault.isCorrectPassword(guess)) {
          System.out.println(this.getName() + " guessed right");
          System.exit(0);
        }
      }
    }
  }

  private static class PoliceThread extends Thread {
    @Override
    public void run() {
      for (int i = 10; i > 0; i--) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(i);
      }
      System.out.println("Game Over for hacker");
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    Random random = new Random();
    int vaultPassword = random.nextInt(MAX_PWD);
    System.out.println("Vault Password is: " + vaultPassword);

    Vault vault = new Vault(vaultPassword);
    List<Thread> threads = new ArrayList<>();
    threads.add(new AscendingHackerThread(vault));
    threads.add(new DescendingHackerThread(vault));
    threads.add(new PoliceThread());
    for (Thread t: threads) {
      t.start();
    }
  }
}
