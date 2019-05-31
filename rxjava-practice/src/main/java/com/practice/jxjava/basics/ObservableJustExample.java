package com.practice.jxjava.basics;

import rx.Observable;

public class ObservableJustExample {

	public static void main(String[] args) {
		// just supports only till 10 params
		Observable.just("one", "two", "two", "two", "two", "two", "two", "evee")
			.subscribe(part -> System.out.println(part));
		
		Observable<String> obs = Observable.just("one", "two", "two", "two", "two", "two", "two", "evee");
		obs.first().subscribe(item -> System.out.println(item));
		
		System.out.println(obs.last().subscribe(item -> System.out.println(item)));

	}

}
