package com.om.poc.util;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EncodingTest {

  private static int escapeCharsTill = 0;

  public static void main(String[] args) {
    String input1 = "Hello World";
    String input2 = "Have you tried turning it off and on again?";
    String input3 = "The quick brown fox jumps over the lazy dog";
    String input4 = "\"Why haven't you finished the exercise yet?\" said Nate.";
    String input5 = "You've never heard of the Millennium Falcon? It's the ship that made the Kessel Run in less than 12 parsecs.";
    String input6 = "The one from the village, FN2187";
    String input7 = "1234567890bcdfghjklmnpqrstvwxyzaeiou";
    String input8 = "He asked for a 13 but they drew a 31";

//    System.out.println(getEncoding(input1));
//    System.out.println(getEncoding(input2));
//    System.out.println(getEncoding(input3));
//    System.out.println(getEncoding(input4));
//    System.out.println(getEncoding(input5));
//    System.out.println(getEncoding(input6));
//    System.out.println(getEncoding(input7));
    System.out.println(getEncoding(input8));
  }



  private static String getEncoding(final String input) {
    StringBuilder sb = new StringBuilder();
    char[] inputChar = input.toLowerCase().toCharArray();


    for (int i = 0; i < inputChar.length; i++) {
      if (escapeCharsTill <= i) {

        if (Character.isAlphabetic(inputChar[i])) {
          if (inputChar[i] == 'y') {
            sb.append(' ');
          } else if (isVowel(inputChar[i])) {
            sb.append(getVowelSubstitute(inputChar[i]));
          } else if (!isVowel(inputChar[i])) {
            sb.append(getCharBeforeGivenChar(inputChar[i]));
          }
        }
        else if (Character.isSpaceChar(inputChar[i])) {
          sb.append('y');
        }
        else if (Character.isDigit(inputChar[i])) {
          escapeCharsTill = i;
          sb.append(reverseFoundNumber(i, input));
        } else {
          sb.append(inputChar[i]);
        }
      }
    }

    return sb.toString();
  }

  /**
   * this method finds all the continuous occuring numbers and reverses it
   * @param index
   * @param input
   * @return
   */
  private static String reverseFoundNumber(final int index, final String input) {
    StringBuilder inputNumberFound = new StringBuilder();
    for (int i = index; i < input.length(); i++) {
      char c = input.charAt(i);
      if(Character.isDigit(c)) {
        inputNumberFound.append(c);
        escapeCharsTill++;
      } else {
        break;
      }
    }
    return inputNumberFound.reverse().toString();
  }

  /**
   * this method gets the char occuring before the given char
   * @param c
   * @return
   */
  private static char getCharBeforeGivenChar(final char c) {
    int intValue = (int)c;
    intValue--;
    return  (char) intValue;
  }

  /**
   * this method gets number for the vowel char substitution
   * @param c
   * @return
   */
  private static int getVowelSubstitute(final char c) {
    switch (c){
      case 'a':
        return 1;
      case 'e':
        return 2;
      case 'i':
        return 3;
      case 'o':
        return 4;
      case 'u':
        return 5;
    }
    return -1;
  }

  /**
   * this method checks if a char is vowel or not
   * @param c
   * @return
   */
  private static boolean isVowel(final char c) {
    return "aeiou".indexOf(c) >= 0;
  }
}
