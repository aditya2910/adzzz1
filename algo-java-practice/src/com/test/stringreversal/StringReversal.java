package com.test.stringreversal;

import java.util.Arrays;

public class StringReversal {

	public static void main(String[] args) {
		System.out.println(reverseString("Apple"));
	}

	private static String reverseString(String str) {
		StringBuilder strBdr = new StringBuilder();
		strBdr.append(str);
		
		return strBdr.reverse().toString();
	}
}
