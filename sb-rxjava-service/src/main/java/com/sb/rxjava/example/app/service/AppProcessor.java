package com.sb.rxjava.example.app.service;

import java.util.List;

import rx.Observable;

public interface AppProcessor {
	
	Observable<Integer> getNumbers1to10();

}
