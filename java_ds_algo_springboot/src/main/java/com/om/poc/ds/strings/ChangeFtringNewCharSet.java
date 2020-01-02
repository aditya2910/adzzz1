package com.om.poc.ds.strings;

/**
 * https://www.geeksforgeeks.org/change-string-to-a-new-character-set/
 */
public class ChangeFtringNewCharSet {

  public static void main(String[] args) {
    String charSet = "qwertyuiopasdfghjklzxcvbnm";
    String input = "utta";

    String newCharSet = getNewCharSet(charSet.toCharArray(), input);
    System.out.println(newCharSet);
  }

  private static String getNewCharSet(final char charSet[], final String input) {
    int n = input.length();

    // hashing for new character set
    char hashChar[] = new char[26];
    for (int i = 0; i < 26; i++) {

      hashChar[Math.abs(charSet[i] - 'a')] = (char) ('a' + i);
    }

    // conversion of new character set
    String s="";
    for (int i = 0; i < n; i++) {
      s += hashChar[input.charAt(i) - 'a'];
    }
    return s;
  }
}
