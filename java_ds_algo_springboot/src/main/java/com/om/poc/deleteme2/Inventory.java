package com.om.poc.deleteme2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class Inventory {

  private static class InventoryCounter {
    private int item = 0;

    public void increement() {
      synchronized (this) {
        item++;
      }
    }

    public void decrement() {
      synchronized (this) {
        item--;
      }
    }

    public int getIteems() {
      synchronized (this) {
        return item;
      }
    }

    //checkForDataRace y > x
  }

  public static class IncremnetingThread extends  Thread{
    private InventoryCounter inventoryCounter;

    public IncremnetingThread(InventoryCounter inventoryCounter) {
      this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        inventoryCounter.increement();
      }
    }
  }

  public static class DecrementingThread extends  Thread{
    private InventoryCounter inventoryCounter;

    public DecrementingThread(InventoryCounter inventoryCounter) {
      this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        inventoryCounter.decrement();
      }
    }
  }

  public static void main(String[] args) {
    InventoryCounter inventoryCounter = new InventoryCounter();
    IncremnetingThread it = new IncremnetingThread(inventoryCounter);
    DecrementingThread dt = new DecrementingThread(inventoryCounter);

    it.start();
    dt.start();
    try {
      it.join();
      dt.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


//    try {
//      it.start();
//      it.join();
//      dt.start();
//      dt.join();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    System.out.println(inventoryCounter.getIteems());


  }
}
