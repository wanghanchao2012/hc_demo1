package com.emarbox.example.part06;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import reactor.core.publisher.Flux;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger ai = new AtomicInteger();
		Function<Flux<String>, Flux<String>> filterAndMap = f -> {
			System.out.println("11111111111111111111111111111111");
			if (ai.incrementAndGet() == 1) {
				return f.filter(color -> !color.equals("orange")).map(String::toUpperCase);
			}
			return f.filter(color -> !color.equals("purple")).map(String::toUpperCase);
		};

/*		Flux<String> composedFlux = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
				.doOnNext(System.out::println).compose(filterAndMap);
		composedFlux.subscribe(d -> System.out.println("Subscriber 1 to Composed MapAndFilter :" + d));
		System.out.println(ai.intValue());
		composedFlux.subscribe(d -> System.out.println("Subscriber 2 to Composed MapAndFilter: " + d));
		System.out.println(ai.intValue());	*/	
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		Flux<String> composedFlux1 = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
				.doOnNext(System.out::println).transform(filterAndMap);
		composedFlux1.subscribe(d -> System.out.println("Subscriber 1 to Composed MapAndFilter :" + d));
		System.out.println(ai.intValue());
		composedFlux1.subscribe(d -> System.out.println("Subscriber 2 to Composed MapAndFilter: " + d));
		System.out.println(ai.intValue());
	}

}
