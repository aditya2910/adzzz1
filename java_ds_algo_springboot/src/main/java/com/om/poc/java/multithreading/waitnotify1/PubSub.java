package com.om.poc.java.multithreading.waitnotify1;

import java.util.LinkedList;
import java.util.Queue;

public class PubSub {

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    int max_size = 5;

    Thread producer = new Producer(queue, max_size, "PRODUCER");
    Thread consumer = new Consumer(queue, max_size, "CONSUMER");
    producer.start();
    consumer.start();

  }
}
