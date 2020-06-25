package com.codeisgood;

import java.util.stream.IntStream;

public class QueueImplTest {

  public static void main(String[] args) {
    QueueImpl queueImpl = new QueueImpl();
    IntStream.range(1, 6).forEach(x -> queueImpl.enqueue(x));

    //queueImpl.printQueue();

    queueImpl.pop();

    //queueImpl.printQueue();

    queueImpl.enqueue(10);

    //queueImpl.printQueue();

    queueImpl.pop();
    queueImpl.enqueue(111);

    queueImpl.printQueue();
  }
}
