package com.test.reverseint;

public class ReverseInteger {
	
//	15 = 51
//	-21 = -12
//	-90 = -9
			
	
	public static void main(String[] args) {
		System.out.println(reverseInt(-15678));
	}

	private static int reverseInt(int n) {
		int reverse = 0;
		while(n != 0)
	      {
	          reverse = reverse * 10; // this is the main logic
	          System.out.println("reverse1: "+reverse);
	          reverse = reverse + n%10;
	          System.out.println("reverse2: "+reverse);
	          System.out.println("n%10: "+ n%10);
	          n = n/10;
	          //System.out.println("n: "+n);
	      }	
		return reverse;
	}

}
