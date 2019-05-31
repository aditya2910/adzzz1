package com.practice.jxjava.manupulatingobservables.operators;

import java.util.Random;

import rx.Observable;

/**
 * NOTE: rxjava operators transform one obseervable to another
 * @author adityakumar
 *
 */
public class Operators1 {
	
	public static Observable<Integer> getAnyKindOfObservableData() {
		return Observable.just(1000,222, 4211,577, 566);
	}

	public static void main(String[] args) {
		Random random = new Random();
		
		// changing the values of getAnyKindOfObservableData
		getAnyKindOfObservableData().map(item -> random.nextInt(20));
		getAnyKindOfObservableData().subscribe(item -> System.out.println(item)); 
		
		
		
		// making map random
	}

}
