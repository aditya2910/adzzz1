package com.om.poc.ds.bst;

import java.util.Arrays;

public class TreeCRUD {

  public static void main(String[] args) {
    int[] arr = {6,4,8,3,7,9,2};

    //create BST
    BST bst = new BST(5);
    Arrays.stream(arr)
        .forEach(n -> addNodeInBST(bst, n, bst.root));

    System.out.println(bst);

    printInOrderTraversalOfBst(bst);
    printPreOrderTraversalOfBst(bst);
  }

  private static void addNodeInBST(final BST bst, final int n, final Node root) {
    bst.addNode(n, root);
  }

  private static void printInOrderTraversalOfBst(final BST bst) {
    bst.printInOrder(bst.root);
    System.out.println();
  }

  private static void printPreOrderTraversalOfBst(final BST bst) {
    bst.printPreOrder(bst.root);
  }



}
