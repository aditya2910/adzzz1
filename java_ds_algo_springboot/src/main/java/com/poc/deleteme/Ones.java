package com.poc.deleteme;

import java.util.Stack;
import java.util.regex.Pattern;

public class Ones {

  public static void main(String[] args) {
    String str = "ab2bc12de";
    String result = encodeNumbers(str);
    System.out.println(result);
  }

  private static String encodeNumbers(final String str) {
    char[] strChars = str.toCharArray();
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < strChars.length; i++) {
      if(stack.isEmpty()) {
        stack.push(String.valueOf(strChars[i]));
      } else {
        if(Character.isAlphabetic(strChars[i]))
          stack.push(String.valueOf(strChars[i]));
        else {
          String  item = stack.peek();
          if(Pattern.matches("[a-zA-z]+", item)) {
            stack.push(String.valueOf(strChars[i]));
          } else {
            item = item + String.valueOf(strChars[i]);
            stack.pop();
            stack.push(item);
          }
        }
      }
    }

    System.out.println(stack);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < stack.size(); i++) {
      if(Pattern.matches("[a-zA-Z]+", stack.peek())) {

      }
    }

    return null;
  }
}
