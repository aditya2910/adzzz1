package com.poc.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

  public Node head;
  private Node tail;

  LinkedList(final int value) {
    this.head = new Node(value, null);
    tail = this.head;
  }

  void addNode(final int value) {
    Node node = new Node(value, null);
    tail.setNextNode(node);
    tail = node;
  }

  void printLinkedListFromHeadTotail(final Node headNode) {
    Node linkedListNodes = headNode;
    while(linkedListNodes.getNextNode() != null) {
      System.out.println(linkedListNodes.getValue());
      linkedListNodes = linkedListNodes.getNextNode();
    }
    System.out.println(tail.getValue());
  }

  LinkedList removeDuplicatesFromLinkedList(final Node headNode) {
    Set<Integer> numbers = new HashSet<>();
    Node tempNode = headNode.getNextNode();
    LinkedList finalList = new LinkedList(headNode.getValue());

    while(tempNode != null) {
      if(numbers.contains(tempNode.getValue())) {
        if(null != tempNode.getNextNode())
          tempNode = tempNode.getNextNode();
        else {
          tempNode = null;
        }
        continue;
      } else {
        numbers.add(tempNode.getValue());
        finalList.addNode(tempNode.getValue());
        tempNode = tempNode.getNextNode();
      }
    }
    return finalList;
  }
}
