package com.demo.orgname.util;

public class StringUtility {
	
	public static boolean checkIfStringIsNotNullOrEmpty(String inputString) {
		if(inputString == null || inputString.isEmpty() || inputString.length() == 0) {
			return false;
		}
		return true;
	}

}
