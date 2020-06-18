package com.om.poc.ds.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair
 */
public class CareerFairMaxEvent {
  public static void main(String[] args) {
    //int[] arrival = {1, 3, 3, 5, 7};
    //int[] duration = {2, 2, 1, 2, 1};
    int[] arrival = {1, 3, 3, 5, 7};
    int[] duration = {5, 2, 1, 2, 2};
    System.out.println(maxEvents(arrival, duration));
  }

  private static int maxEvents(final int[] arrivals, final int[] duration) {
    int noOf2DdArrayColumns = 2;
    int[][] events = new int[arrivals.length][noOf2DdArrayColumns];

    for(int i=0; i<arrivals.length;i++){
      events[i][0] = arrivals[i];
      events[i][1] = arrivals[i]+duration[i];
    }

    int columnInADDToSort = 1;
    Comparator<int[]> columnComparator = (arr1, arr2) -> {
      if(arr1[columnInADDToSort] > arr2[columnInADDToSort]) {
        return 1;
      }
      return -1;
    };
    Arrays.sort(events, columnComparator);

    int maxNoOfEvents = 1;
    int lastEventEendTime = events[0][1];
    for (int i = 1; i < arrivals.length; i++) {
      int startTime = events[i][0];
      if(startTime >= lastEventEendTime) {
        lastEventEendTime = events[i][1];
        maxNoOfEvents++;
      }
    }


    return maxNoOfEvents;
  }
}


