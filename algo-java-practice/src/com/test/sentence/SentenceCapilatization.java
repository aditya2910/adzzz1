package com.test.sentence;

public class SentenceCapilatization {

	public static void main(String[] args) {
		System.out.println(capitalizeSentence("I have to improve my algo"));
		System.out.println(capitalizeSentence("I have to improve my algo              "));
		System.out.println(capitalizeSentence("I have to improve my algo "));
		System.out.println(capitalizeSentence("I have to improve my algo ."));
	}

	private static String capitalizeSentence(String str) {
		char[] strArr = str.toCharArray();
		for (int i = 0; i < strArr.length; i++) {
			if (str.charAt(i) == " ".charAt(0) && i + 1 < strArr.length) {
				strArr[i + 1] = String.valueOf(String.valueOf(strArr[i + 1])).toUpperCase().charAt(0);
			}
		}
		System.out.println(String.valueOf(strArr));
		return String.valueOf(strArr);
	}
}
