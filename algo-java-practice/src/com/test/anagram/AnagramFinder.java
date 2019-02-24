package com.test.anagram;

import java.util.Arrays;

public class AnagramFinder {

	public static void main(String[] args) {
		//System.out.println(isAnagram("Rail safety", "fairy tales"));
		//System.out.println(isAnagram("Rail safety!!", "fairy tales"));
		
		System.out.println(isAnagram("Rail safety!!".replaceAll("[^a-zA-Z]+", ""), "fairy tales".replaceAll("[^a-zA-Z]+", "")));
		System.out.println(isAnagram("Rail safety!!".toLowerCase().replaceAll("[^a-zA-Z]+", ""), "fairy tales".toLowerCase().replaceAll("[^a-zA-Z]+", "")));
	}

	private static boolean isAnagram(String str1, String str2) {
		char[] str1CharArr = str1.toCharArray();
		char[] str2CharArr = str2.toCharArray();
		Arrays.sort(str1CharArr);
		Arrays.sort(str2CharArr);
		return Arrays.equals(str1CharArr, str2CharArr);
	}
}
