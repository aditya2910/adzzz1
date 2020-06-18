package com.om.poc.ds.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DMatrixbycolumn {

  public static void sortbyColumn(int arr[][], int col) {
//    Comparator<int[]> arrayComparator = new Comparator<int[]>() {
//      @Override
//      public int compare(final int[] o1, final int[] o2) {
//        //ascending order
//        if(o1[col] > o2[col]) {
//          return 1;
//        }
//        return -1;
//      }
//    };

    Comparator<int[]> arrayComparator = (a1, a2) -> {
      if(a1[col] > a2[col]) {
        return 1;
      }
      return -1;
    };

    Arrays.sort(arr, arrayComparator);

  }

  public static void main(String args[]) {
    int matrix[][] = {{39, 27, 11, 42},
                      {10, 93, 91, 90},
                      {54, 78, 56, 89},
                      {24, 64, 20, 65}};
    // Sort this matrix by 3rd Column
    int col = 3;
    sortbyColumn(matrix, col - 1);

    // Display the sorted Matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
