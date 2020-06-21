package com.poc.ds.strings;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/expression-evaluation/
 */
public class EvaluateExpression {

  public static void main(String[] args)
  {
//    System.out.println(evaluate("10 + 2 * 6"));
//    System.out.println(evaluate("100 * 2 + 12"));
    System.out.println("Result: " + evaluate("100 * ( 2 + 12 )"));
//    System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
  }

  private static String evaluate(String expr) {
    expr = expr.replace(" ", "");
    String result  = "";
    Stack<String> operationStack = new Stack<>();
    Stack<String> operandStack = new Stack<>();



    return result;
  }
}
