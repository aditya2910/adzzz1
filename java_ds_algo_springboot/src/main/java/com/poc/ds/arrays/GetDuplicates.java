package com.poc.ds.arrays;

public class GetDuplicates {

  // function to find repeating elements
  static void printRepeating(int arr[], int n)
  {
    // First check all the values that are
    // present in an array then go to that
    // values as indexes and increment by
    // the size of array
    for (int i = 0; i < n; i++)
    {
      int index = arr[i] % n;
      System.out.println("index: " + index);
      arr[index] += n;
    }

    // Now check which value exists more
    // than once by dividing with the size
    // of array
    for (int i = 0; i < n; i++)
    {
      if ((arr[i]/n) > 1)
        System.out.println(i +" ");
    }
  }

  public static void main(String[] args) {
    int arr[] = {1, 6, 3, 1, 3, 6, 6};
    int arr_size = arr.length;

    System.out.println("The repeating elements are: ");
    printRepeating( arr, arr_size);
  }
}
