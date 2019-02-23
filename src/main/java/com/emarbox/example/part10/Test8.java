package com.emarbox.example.part10;

import java.util.function.Function;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

public class Test8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 63)
			.groupBy(i -> i % 2 == 0 ? "even" : "odd")
			.concatMap(new Function<GroupedFlux<String, Integer>, Publisher<String>>() {
					@Override
					public Flux<String> apply(GroupedFlux<String, Integer> g) {
						return g.map(new Function<Integer, String>() {
							@Override
							public String apply(Integer t) {
								return String.valueOf(t);
							}
						}).startWith(g.key());
					}
				})
			.subscribe(System.out::println);

		Thread.sleep(30000);
	}

}
