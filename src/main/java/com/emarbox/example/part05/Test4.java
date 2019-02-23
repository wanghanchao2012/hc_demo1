package com.emarbox.example.part05;

import java.time.Duration;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Test4 {
	private static Flux<Integer> evenNumbers = Flux.just(4, 5, 6);
	private static Flux<Integer> oddNumbers = Flux.just(1, 2, 3);

	public static void main(String[] args) throws InterruptedException {
		Flux.zip(evenNumbers, oddNumbers)
		.map(e -> {
			if (e.getT1().intValue() == 6) {
				throw new RuntimeException();
			}
			return e.getT1();
		})
		.log()
		.retryWhen(companion -> companion.zipWith(Flux.range(1, 4), (error, index) -> {
			if (index < 4)
				return index;
			else
				throw Exceptions.propagate(error);
		}).flatMap(e -> {
			System.out.println("e----" + e);
			return Mono.delay(Duration.ofSeconds(2 * e));
		})).doOnNext(b -> System.out.println("xxxxxxxxxxx==" + b)).collectList().block();
		;
		Thread.sleep(100000);
	}
}
