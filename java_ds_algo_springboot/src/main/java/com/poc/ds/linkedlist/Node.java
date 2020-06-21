package com.poc.ds.linkedlist;

public class Node {

  private Node nextNode;
  private int value;

  public Node(final int value, final Node nextNode) {
    this.nextNode = nextNode;
    this.value = value;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(final Node nextNode) {
    this.nextNode = nextNode;
  }

  public int getValue() {
    return value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
