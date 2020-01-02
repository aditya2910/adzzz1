package com.om.poc.ds.strings;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/
 */
public class DecodeString {

  public static void main(String[] args) {
    String str = "2[ab]2[cd]";
    String decodedStr = decodeStr(str);
    System.out.println(decodedStr);
  }

  private static String decodeStr(String str) {

    Stack<Integer> integerstack = new Stack<>();
    Stack<Character> stringstack = new Stack<>();
    String result = "";

    for (int i = 0; i < str.length(); i++) {
      if (Character.isDigit(str.charAt(i))) {
        integerstack.push(Character.getNumericValue(str.charAt(i)));
      } else if (Character.isAlphabetic(str.charAt(i)) || str.charAt(i) == '[') {
        stringstack.push(str.charAt(i));
      } else if (str.charAt(i) == ']') {
        String temp = "";
        while (stringstack.peek() != '[') {
          temp = stringstack.pop() + temp;
        }

        stringstack.pop(); // removing [
        String mulStr = multiplyStr(temp, integerstack.pop());

        for (int j = 0; j < mulStr.length(); j++) {
          stringstack.push(mulStr.charAt(j));
        }
      }

    }
    int finalSize = stringstack.size();
    for (int j = 0; j < finalSize; j++) {
      result = stringstack.pop() + result;
    }

    return result;
  }

  private static String multiplyStr(final String decodedStr, final int pop) {
    //int n = Integer.parseInt(String.valueOf(pop));
    int n = pop;
    String multiplyedStr = "";
    for (int i = 0; i < n; i++) {
      multiplyedStr = multiplyedStr + decodedStr;
    }

    return multiplyedStr;
  }
}
