package com.poc.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class FindMinPlatformsSoNoTrainWait {

  public static void main(String[] args) {
    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    System.out.println("Minimum Number of Platforms Required: "
        + findPlatform(arr, dep));
  }

  private static int findPlatform(final int[] arr, final int[] dep) {
    List<Integer> departuresOfParkedTrains = new ArrayList<>();
    int noOfPlatforms = 0;
    int[][] trainsArrDept =  getTrainsArrDept(arr, dep);

    for (int i = 0; i < trainsArrDept.length; i++) {
      if( departuresOfParkedTrains.size() == 0) {
        departuresOfParkedTrains.add(trainsArrDept[i][1]);
        noOfPlatforms++;
      } else {
        Collections.sort(departuresOfParkedTrains);
        int lastDepartTimeRecorded = departuresOfParkedTrains.get(0);
        if(lastDepartTimeRecorded < trainsArrDept[i][0]) {
          departuresOfParkedTrains.remove(0);
          departuresOfParkedTrains.add(0, trainsArrDept[i][1]);
        } else {
          departuresOfParkedTrains.add(trainsArrDept[i][1]);
          noOfPlatforms++;
        }
      }


    }

    return noOfPlatforms;
  }

  private static int[][] getTrainsArrDept(final int[] arr, final int[] dep) {
    int[][] trainsArrDept = new int[arr.length][2];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < 2; j++) {
        if(j == 0) {
          trainsArrDept[i][0] = arr[i];
        } else {
          trainsArrDept[i][1] = dep[i];
        }
      }
    }
    return trainsArrDept;
  }
}
