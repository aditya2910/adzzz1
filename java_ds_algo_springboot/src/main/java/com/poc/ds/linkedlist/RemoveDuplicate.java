package com.poc.ds.linkedlist;

public class RemoveDuplicate {

  public static void main(String[] args) {
    //create linked list with some duplicate elements
    int[] numbers = {1,2,3,4,5,5,6,7,8,9,9};
    LinkedList linkedList = getLinkedList(numbers);

    //print elements of linked list
    //linkedList.printLinkedListFromHeadTotail(linkedList.head);

    //remove duplicate elements from list
    LinkedList nodes = linkedList.removeDuplicatesFromLinkedList(linkedList.head);
    System.out.println(nodes);
    linkedList.printLinkedListFromHeadTotail(nodes.head);
  }



  private static LinkedList getLinkedList(final int[] numbers) {

    LinkedList linkedList = new LinkedList(numbers[0]);
    for (int i = 1; i < numbers.length; i++) {
      linkedList.addNode(numbers[i]);
    }

    return linkedList;
  }

}
