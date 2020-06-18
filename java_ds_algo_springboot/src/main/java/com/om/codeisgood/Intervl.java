package com.om.codeisgood;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Intervl {

  public static void main(String[] args) {
    Integer[] arr = {7,6,6,3,9,3,5,1 };
    List<Integer> list = Arrays.asList(arr);
    int count = stockPairs(list, 12);
    System.out.println(count);
  }

  private static int stockPairs(final List<Integer> socksProfit, final int target) {
    int count = 0;
    Map<Integer, Integer> repeats = new HashMap<>();

    for (int i = 0; i < socksProfit.size(); i++) {

      for (int j = i+1; j < socksProfit.size(); j++) {
        int sum = socksProfit.get(i) + socksProfit.get(j);

        if(!repeats.containsKey(socksProfit.get(j))) {
          repeats.put(socksProfit.get(j), 1);
        } else {
          repeats.put(socksProfit.get(j), 2);
        }
        System.out.println(repeats);
        System.out.println(socksProfit.get(j));
        System.out.println(repeats.get(socksProfit.get(j)));
        if(sum == target && repeats.get(socksProfit.get(j)) == 1) {
          System.out.println(socksProfit.get(i) + " - "+ socksProfit.get(j));
          count++;
        }
      }
    }
    return count;
  }


}
