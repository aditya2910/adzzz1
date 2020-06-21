package com.poc.deleteme2;

import java.util.Random;


public class RailroadTrafficControl {

  public static class Intersection {

    private Object roadA = new Object();
    private Object roadB = new Object();

    public void takeRoadA() {
      synchronized (roadA) {
        System.out.println("Road A is locked");
        synchronized (roadB) {
          System.out.println("Train is passing through Road A");
          waitTillTrainPasses();
        }
      }
    }

    public void takeRoadB() {
      synchronized (roadB) {
        System.out.println("Road B is locked");

        synchronized (roadA) {
          System.out.println("Train is passing through Road B");
          waitTillTrainPasses();
        }
      }
    }

    private void waitTillTrainPasses() {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  private static class TrainA implements Runnable {
    private Intersection intersection;
    private Random random = new Random();

    public TrainA(Intersection intersection) {
      this.intersection = intersection;
    }

    @Override
    public void run() {
      while (true) {
        long sleeingTime = random.nextInt(5);
        try {
          Thread.sleep(sleeingTime);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        //intersection.takeRoadA();
      }

    }
  }


  private static class TrainB implements Runnable {
    private Intersection intersection;
    private Random random = new Random();

    public TrainB(Intersection intersection) {
      this.intersection = intersection;
    }

    @Override
    public void run() {
      while (true) {
        long sleeingTime = random.nextInt(5);
        try {
          Thread.sleep(sleeingTime);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        intersection.takeRoadB();
      }

    }
  }

  public static void main(String[] args) {
    Intersection intersection = new Intersection();
    Thread trainAThread = new Thread(new TrainA(intersection));
    Thread trainBThread = new Thread(new TrainB(intersection));
    trainAThread.start();
    trainBThread.start();


  }
}
