package com.adzzz.dsa.singlylinkedlist;

public class ReverseSinglyLinkedList {

	public static void main(String[] args) {
		System.out.println("Create singly list with 4 values - 1, 2, 3, 4");
		SinglyNode list = createSinglyLinkedList();
		printListContent(list);
		
		SinglyNode reversedList = reverseSinglyLinkedList(list);
		printListContent(list);

	}

	private static SinglyNode reverseSinglyLinkedList(SinglyNode list) {
		// TODO Auto-generated method stub
		return null;
	}

	private static SinglyNode createSinglyLinkedList() {
		SinglyNode node1 = new SinglyNode(1);
		SinglyNode node2 = new SinglyNode(2);
		node1.setNode(node2);
		SinglyNode node3 = new SinglyNode(3);
		node2.setNode(node3);
		SinglyNode node4 = new SinglyNode(4);
		node3.setNode(node4);
		
		return node1;
	}
	
	private static void printListContent(SinglyNode list) {
		System.out.println(list.getValue());
		if(list.getNode() == null) {
			return;
		}
		printListContent(list.getNode());
	}
}
