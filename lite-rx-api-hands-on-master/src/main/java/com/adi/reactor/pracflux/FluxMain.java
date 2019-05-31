package com.adi.reactor.pracflux;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxMain {

	public static void main(String[] args) {

		//simpleFlux();
		
		fluxWithZipwith();
		
		
	}

	private static void fluxWithZipwith() {
		List<String> elements = new ArrayList<>();
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2)
		  .zipWith(Flux.range(0, Integer.MAX_VALUE), 
		    (firstFlux, secondFlux) -> String.format("First Flux: %d, Second Flux: %d", firstFlux, secondFlux))
		  //.subscribeOn(Schedulers.parallel())
		  .subscribe(elements::add);
		
		elements.stream()
			.forEach(System.out::println);
		
	}

	private static void simpleFlux() {
		List<Integer> elements = new ArrayList<>();
		Flux.just(1, 2, 3, 4)
			.log()
			.map(i -> i * 2)
			.subscribe(elements::add);
		
		elements.stream()
			.forEach(System.out::println);
	}

}
