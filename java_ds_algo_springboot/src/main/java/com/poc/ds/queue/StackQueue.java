package com.poc.ds.queue;

public class StackQueue {

  private static int SIZE_OF_QUEUE = 5;
  private static int HEAD = -1;
  private static int TAIL = -1;

  public static void main(String[] args) {
    int[] queue = new int[SIZE_OF_QUEUE];

    pushToQueue(queue, 10);
    pushToQueue(queue, 20);
    pushToQueue(queue, 30);
    pushToQueue(queue, 40);
    pushToQueue(queue, 50);

    int itemPopped1 = popFromQueue(queue);
    System.out.println("Printing from queue: " + itemPopped1);
    int itemPopped2 = popFromQueue(queue);
    System.out.println("Printing from queue: " + itemPopped2);

    pushToQueue(queue, 60);
    pushToQueue(queue, 70);
    pushToQueue(queue, 80);

    System.out.println("#################################");
    printQueueByPoppingAllElements(queue);
  }

  private static int popFromQueue(final int[] queue) {
    if (TAIL == -1) {
      throw new IllegalArgumentException("Queue is Empty");
    }
    if(HEAD <= TAIL) {
      int itemPopped = queue[HEAD];
      queue[HEAD] = 0;
      HEAD = HEAD + 1;
      return itemPopped;
    }
    return -1;
  }

  private static void printQueueByPoppingAllElements(final int[] queue) {
    for (int i = HEAD; i <= TAIL; i++) {
      int itemPopped = popFromQueue(queue);
      System.out.println("Printing from queue: " + itemPopped);
    }
  }

  private static void pushToQueue(final int[] queue, final int value) {
    if (isQueueFull(queue)) {
      throw new IllegalArgumentException("Queue is full");
    }
    if (HEAD == -1) {
      HEAD = 0;
    }

    if (TAIL == queue.length - 1) {
      TAIL = 0;
      queue[TAIL] = value;
    } else {
      TAIL = TAIL + 1;
      queue[TAIL] = value;
    }
  }

  private static boolean isQueueFull(final int[] queue) {
    int itemsInQueue;
    if(TAIL < HEAD) {
      itemsInQueue = (TAIL + 1) + (queue.length - HEAD);
    } else {
      itemsInQueue = 1 + (TAIL - HEAD);
    }
    if(itemsInQueue == queue.length)
      return true;
    return false;
  }
}
