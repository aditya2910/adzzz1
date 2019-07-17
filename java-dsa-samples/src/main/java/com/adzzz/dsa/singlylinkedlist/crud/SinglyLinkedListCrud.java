package com.adzzz.dsa.singlylinkedlist.crud;

public class SinglyLinkedListCrud {

	public static void main(String[] args) {
		// Create singly list with 4 items
		SinglyNode list = createSinglyLinkedList();
		// Read singly list with 4 items
		printListContent(list);
		
		// Update node with 3 to 9
		SinglyNode updatedList = updateSinglyLinkedList(list, 3, 9);
		printListContent(updatedList);
	}

	private static SinglyNode updateSinglyLinkedList(SinglyNode list, int oldValue, int newValue) {
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
