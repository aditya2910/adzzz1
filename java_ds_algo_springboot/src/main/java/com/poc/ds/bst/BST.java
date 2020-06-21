package com.poc.ds.bst;

public class BST {

  Node root;

  public BST(int value) {
    this.root = new Node(value);
  }

  Node addNode(final int value, final Node node) {

    if(node == null)
      return new Node(value);

    if(node.value > value)
      node.left = addNode(value, node.left);

    if(node.value < value)
      node.right = addNode(value, node.right);

    return node;
  }

  void printInOrder(final Node node) {
    if(node == null) {
      return;
    }

    printInOrder(node.left);
    System.out.print(node.value + " ");
    printInOrder(node.right);
  }

  void printPreOrder(final Node node) {
    if(node == null) {
      return;
    }
    System.out.print(node.value + " ");
    printPreOrder(node.left);
    printPreOrder(node.right);
  }
}
