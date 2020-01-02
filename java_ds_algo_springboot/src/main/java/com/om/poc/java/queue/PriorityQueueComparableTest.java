package com.om.poc.java.queue;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Exception in thread "main" java.lang.ClassCastException: com.om.poc.java.queue.EmployeeNoComparable cannot be cast to java.lang.Comparable
 */
public class PriorityQueueComparableTest {

  public static void main(String[] args) {
    PriorityQueue<EmployeeComparable> priorityQueue = new PriorityQueue<>();

    IntStream stream = IntStream.range(1, 10);
    stream.forEach( x -> {
      EmployeeComparable employeeComparable = new EmployeeComparable(x, "Name-"+x, "Dept1", x*1000);
      priorityQueue.add(employeeComparable);
    });


    while (priorityQueue.size() != 0) {
      System.out.println(priorityQueue.poll().getId());
    }
  }
}
