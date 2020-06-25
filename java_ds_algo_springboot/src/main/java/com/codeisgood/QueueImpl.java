package com.codeisgood;

public class QueueImpl {

  private int[] queue;
  private int head;
  private int tail;
  private int size;

  public QueueImpl() {
    queue = new int[5];
    head = 0;
    tail = 0;
    size = 0;
  }

  public void enqueue(int no) {
    if(size == queue.length) {
      throw new IllegalArgumentException("Queue is full");
    }
    if(tail == queue.length){
        tail = 0;
    }
    queue[tail] = no;
    tail++;
    size++;
  }

  public void printQueue() {
    for (int i = 0; i < queue.length; i++) {
      System.out.println(i + " : " + queue[i]);
    }
  }

  void pop() {
    System.out.println("Popping: " + queue[head]);
    queue[head] = 0;
    head++;
    size--;
  }
}
