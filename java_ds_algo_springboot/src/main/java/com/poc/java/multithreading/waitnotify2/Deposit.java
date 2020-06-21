package com.poc.java.multithreading.waitnotify2;

public class Deposit implements Runnable {

  Account account;
  int depositAmount;

  public Deposit(Account account, int depositAmount) {
    this.account = account;
    this.depositAmount = depositAmount;
  }

  @Override
  public void run() {
    synchronized (this.account) {
      System.out.println("deposited : " + depositAmount);
      account.setBalance(account.getBalance() + depositAmount);

      account.notifyAll();
      System.out.println("after notify");
    }
  }
}
