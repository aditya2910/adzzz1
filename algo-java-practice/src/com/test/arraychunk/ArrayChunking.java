package com.test.arraychunk;

import java.util.Arrays;

public class ArrayChunking {

	public static void main(String[] args) {
		int[] original = new int[] {1,2,3,4,5,6,7,8,9}; 
		int chunk = 2; // chunk size to divide
		for(int i=0;i<original.length;i+=chunk){
		    System.out.println( Arrays.toString( Arrays.copyOfRange( original, i, Math.min(original.length,i+chunk))));
			//int[] chunkedArr = Arrays.copyOfRange( original, i, Math.min(original.length,i+chunk));
			//System.out.println("chunkedArr: " + chunkedArr.length);
		}   
	}
}
