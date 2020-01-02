package com.om.poc.java.queue;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PriorityQueueComparatorTest {

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
  // TODO
  //Comparable<Employee>
}
