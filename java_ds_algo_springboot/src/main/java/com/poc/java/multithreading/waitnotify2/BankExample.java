package com.poc.java.multithreading.waitnotify2;

public class BankExample {

  public static void main(String[] args) {
    int balance = 1000;
    Account account = new Account("AC101", balance);

    Withdraw withdraw = new Withdraw(account, 1500);
    Deposit deposit = new Deposit(account, 900);

    Thread withdrawThread = new Thread(withdraw);
    Thread depositThread = new Thread(deposit);

    withdrawThread.start();
    depositThread.start();
  }
}
