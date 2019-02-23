package com.emarbox.example.part05;

import java.time.Duration;
import java.time.LocalTime;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		Flux.<String> error(new IllegalArgumentException()).log().retryWhen(companion -> companion.doOnNext(s -> {
			System.out.println(s + " at " + LocalTime.now());
		}).zipWith(Flux.range(1, 10), (error, index) -> {
			System.out.println("index==" + index);
			if (index < 9)
				return index;
			else
				throw Exceptions.propagate(error);
		}).flatMap(index -> Mono.delay(Duration.ofMillis(index * 100)))
				.doOnNext(s -> System.out.println("retried at " + LocalTime.now()))).subscribe(System.out::print);

		
		Thread.sleep(100000);
	}

}
