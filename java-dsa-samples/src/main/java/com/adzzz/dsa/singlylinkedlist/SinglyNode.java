package com.adzzz.dsa.singlylinkedlist;


public class SinglyNode implements Cloneable {

	private int value;
	private SinglyNode node;
	
	public SinglyNode(int value) {
		super();
		this.value = value;
		this.node = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SinglyNode getNode() {
		return node;
	}

	public void setNode(SinglyNode node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "SinglyNode [value=" + value + ", node=" + node + "]";
	}
	
	@Override
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  
	
}
