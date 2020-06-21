package com.poc.java.queue;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Exception in thread "main" java.lang.ClassCastException: com.poc.java.queue.EmployeeNoComparable cannot be cast to java.lang.Comparable
 */
public class PriorityQueueNoComparableTest {

  public static void main(String[] args) {
    PriorityQueue<EmployeeNoComparable> priorityQueue = new PriorityQueue<>();

    IntStream stream = IntStream.range(1, 10);
    stream.forEach( x -> {
      EmployeeNoComparable employeeNoComparable = new EmployeeNoComparable(x, "Name-"+x, "Dept1", x*1000);
      priorityQueue.add(employeeNoComparable);
    });


    while (priorityQueue.size() != 0) {
      System.out.println(priorityQueue.poll().getId());
    }
  }
}
