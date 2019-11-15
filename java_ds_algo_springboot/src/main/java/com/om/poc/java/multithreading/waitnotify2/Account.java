package com.om.poc.java.multithreading.waitnotify2;

public class Account {

  String bankAccountNo;
  int balance;
  int depositAmount;
  int withdrawAmount;

  public Account(final String bankAccountNo, final int balance) {
    this.bankAccountNo = bankAccountNo;
    this.balance = balance;
  }

  public String getBankAccountNo() {
    return bankAccountNo;
  }

  public void setBankAccountNo(final String bankAccountNo) {
    this.bankAccountNo = bankAccountNo;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(final int balance) {
    this.balance = balance;
  }

  public int getDepositAmount() {
    return depositAmount;
  }

  public void setDepositAmount(final int depositAmount) {
    this.depositAmount = depositAmount;
  }

  public int getWithdrawAmount() {
    return withdrawAmount;
  }

  public void setWithdrawAmount(final int withdrawAmount) {
    this.withdrawAmount = withdrawAmount;
  }
}
