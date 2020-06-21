package com.poc.java.multithreading.waitnotify2;

public class Withdraw implements Runnable{

  Account account;
  int withdrawAmount;

  public Withdraw(Account account, int withdrawAmount) {
    this.account = account;
    this.withdrawAmount = withdrawAmount;
  }

  @Override
  public void run() {
    synchronized (this.account) {
      if(account.getBalance() - withdrawAmount < 0) {
        try {
          System.out.println("Waiting for sufficient Balance. Current Bal= " + account.getBalance() );
          account.wait();
          account.setBalance(account.getBalance() - withdrawAmount);
          System.out.println("after wait. Available Bal= " + account.getBalance());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
