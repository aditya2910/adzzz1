package com.adzzz.dsa.singlylinkedlist;

public class SinglyLinkedListCrud {

	public static void main(String[] args) {
		System.out.println("Create singly list with 4 values - 1, 2, 3, 4");
		SinglyNode list = createSinglyLinkedList();
		
		System.out.println("Read singly list with 4 values - 1, 2, 3, 4");
		printListContent(list);
		
		System.out.println("Update node with value 3 to 9");
		SinglyNode updatedList = updateSinglyLinkedList(list, 3, 9);
		printListContent(updatedList);
		
		System.out.println("Delete node with value 2");
		SinglyNode deletedItemList = deleteSinglyLinkedList(list, 2);
		printListContent(deletedItemList);
		
		System.out.println("Get Length of singly linked list");
		int listLength = getLengthOfSinglyLinkedList(list);
		System.out.println(listLength);
	}

	private static int getLengthOfSinglyLinkedList(SinglyNode list) {
		int counter = 1;
		//TODO: make counter to 0 and return 0 if list is empty
		for (SinglyNode nodeIndex = list.getNode(); nodeIndex != null; nodeIndex = nodeIndex.getNode()) {
			counter++;
		}
		return counter;
	}

	private static SinglyNode deleteSinglyLinkedList(SinglyNode list, int valueToDelete) {
		// TODO: handle first and last nodes
		SinglyNode currentNode = null, matchingValueNextNode = null;
		for (SinglyNode nodeIndex = list.getNode(); nodeIndex != null; nodeIndex = nodeIndex.getNode()) {
			if(valueToDelete == nodeIndex.getValue()) {
				currentNode = nodeIndex;
				matchingValueNextNode = nodeIndex.getNode();
			}
		}
		currentNode.setNode(matchingValueNextNode.getNode());
		currentNode.setValue(matchingValueNextNode.getValue());
		
		return list;
	}

	private static SinglyNode updateSinglyLinkedList(SinglyNode list, int oldValue, int newValue) {
		// TODO: check first node
		SinglyNode matchedNode = null;
		for (SinglyNode tmp = list.getNode(); tmp != null; tmp = tmp.getNode()) {
			if (oldValue == tmp.getValue()) {
				matchedNode = tmp;
			}
		}
		
	    matchedNode.setValue(newValue); 
	    
	    return list;
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
