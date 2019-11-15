package com.om.poc.ds.arrays;

import java.util.Arrays;

public class JumpGame2 {

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

    if(arr[0] != 0) {
      for (int i = 0; i < arr.length; i++) {
        int nextJump = arr[i];
        int[] nextSteps = getNextSteps(arr, i, nextJump);
        printArr(nextSteps);

        int max = 0;
        for (int j = 0; j < nextSteps.length; j++) {
          int jump = nextSteps[j];
          if(jump >= arr.length) {
            max = jump;
            break;
          } else {
            if(max < jump) {
              max = jump;
            }
          }
          i = j;
        }


      }
    }
  }

  private static int[] getNextSteps(final int[] arr, final int initialPosition, final int nextJump) {
    //int noOfStepsThatCanBeMade = arr[initialPosition];
    int[] nextSteps = new int[nextJump];
    for (int i = initialPosition; i < initialPosition + nextJump; i++) {
      nextSteps[i-initialPosition] = arr[i+1];
    }
    return nextSteps;
  }

  private static void printArr(final int[] arrFinal) {
    System.out.println("Printing Array");
    Arrays.stream(arrFinal)
        .forEach(e->System.out.print(e + " "));
    System.out.println();
  }
}
