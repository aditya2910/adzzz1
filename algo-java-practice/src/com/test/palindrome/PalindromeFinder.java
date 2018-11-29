package com.test.palindrome;

public class PalindromeFinder {

	public static void main(String[] args) {
		System.out.println(isPalindrome("madam"));
		System.out.println(isPalindrome("abc"));
	}

	private static boolean isPalindrome(String str) {
		
		char[] strArr = str.toCharArray();
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] != strArr[strArr.length - (1 + i)])
				return false;
		}
		
		return true;
	}
}
