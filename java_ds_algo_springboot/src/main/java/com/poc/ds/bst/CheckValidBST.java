package com.poc.ds.bst;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */
public class CheckValidBST {

  public static void main(String[] args) {
    int[] arr = {10, 5, 1, 7, 40, 50};

    BST bst = new BST(arr[0]);

    Arrays.stream(arr)
        .skip(1)
        .forEach(n -> addNodeToBST(bst, n));

    System.out.println(bst);

    boolean isValidBST = isValidBST(bst);
  }

  private static boolean isValidBST(final BST bst) {
    return validateBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean validateBST(final Node node, final int min, final int max) {
    /* an empty tree is BST */
    if (node == null) {
      return true;
    }

        /* false if this node violates the min/max constraints */
    if (node.value < min || node.value > max) {
      return false;
    }

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
    // Allow only distinct values
    return (validateBST(node.left, min, node.value - 1)
        && validateBST(node.right, node.value + 1, max));
  }

  private static void addNodeToBST(final BST bst, final int value) {
    bst.addNode(value, bst.root);
  }

}
