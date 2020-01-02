package com.om.poc.ds.bst;

import java.util.Arrays;

public class ConstructBSTFromPreOrder {

  public static void main(String[] args) {
    int[] arr = {10, 5, 1, 7, 40, 50};

    BST bst = new BST(arr[0]);

    Arrays.stream(arr)
        .skip(1)
        .forEach(n -> addNodeToBST(bst, n));

    System.out.println(bst);
  }

  private static void addNodeToBST(final BST bst, final int value) {
    bst.addNode(value, bst.root);
  }
}
