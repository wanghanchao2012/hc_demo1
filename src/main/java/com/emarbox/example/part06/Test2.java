package com.emarbox.example.part06;

import java.util.Arrays;
import java.util.function.Function;

import reactor.core.publisher.Flux;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Flux<String>, Flux<String>> filterAndMap = f -> f.filter(color -> !color.equals("orange"))
				.map(String::toUpperCase);

		Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple")).doOnNext(System.out::println)
				.transform(filterAndMap)
				.subscribe(d -> System.out.println("Subscriber to Transformed MapAndFilter: " + d));
	}

}
