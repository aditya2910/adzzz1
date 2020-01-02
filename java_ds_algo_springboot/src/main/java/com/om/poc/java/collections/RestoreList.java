package com.om.poc.java.collections;

import java.util.ArrayList;
import java.util.List;

public class RestoreList {

  private static List<Integer> list = new ArrayList<>();
  private static List<Integer> originalList = new ArrayList<>();

  public static void main(String[] args) {

    list.add(1);
    list.add(2);

    RestoreList restoreList = new RestoreList();
    restoreList.saveList(list);

    list.add(3);
    list.add(4);

    System.out.println("Modified list: " + list);

    list = restoreList.restore();

    System.out.println("Restored list: " + list);
  }

  private List<Integer> restore() {
    return originalList;
  }

  private void saveList(final List<Integer> list) {
    originalList.addAll(list);
  }
}
