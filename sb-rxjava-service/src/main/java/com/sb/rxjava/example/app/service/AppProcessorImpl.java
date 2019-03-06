package com.sb.rxjava.example.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import rx.Observable;

@Component
public class AppProcessorImpl implements AppProcessor {

	@Override
	public Observable<Integer> getNumbers1to10() {
		//return Observable.just(1, 2, 3, 4,5, 6);
		
		return Observable.range(2, 10);
	}

}
