package com.om.poc.ds.arrays;

public class ArrayReverseJuggling {

  void leftRotate(int arr[], int d, int n)
  {
    int i, j, k, temp;
    int g_c_d = gcd(d, n);
    for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
      temp = arr[i];
      j = i;
      while (true) {
        k = j + d;
        System.out.println(k);
        if (k >= n)
          k = k - n;
        if (k == i)
          break;
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp;
    }
  }

    /*UTILITY FUNCTIONS*/

  /* function to print an array */
  void printArray(int arr[], int size)
  {
    int i;
    for (i = 0; i < size; i++)
      System.out.print(arr[i] + " ");
  }

  /*Fuction to get gcd of a and b*/
  int gcd(int a, int b)
  {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  // Driver program to test above functions
  public static void main(String[] args)
  {
    ArrayReverseJuggling rotate = new ArrayReverseJuggling();
    int arr[] = { 1, 2, 3, 4, 5, 6, 7 ,8,9,10,11,12};
    rotate.leftRotate(arr, 14, 12);
    rotate.printArray(arr, 12);
  }
}
