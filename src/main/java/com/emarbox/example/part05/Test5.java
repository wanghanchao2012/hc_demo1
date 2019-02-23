package com.emarbox.example.part05;

import java.time.Duration;
import java.time.LocalTime;
import java.util.function.BiFunction;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		Mono.<String> create(sink -> {
			System.out.println("ddddddddddddddddddddddddddd");
			if(true){
				throw new RuntimeException();
			}
			sink.success("111");
			
		}).retryWhen(companion -> companion.doOnNext(s -> System.out.println(s + " at " + LocalTime.now()))
				.zipWith(Flux.range(1, 4), (error, index) -> {
					if (index < 4)
						return index;
					else
						throw Exceptions.propagate(error);
				}).flatMap(index -> {
					System.out.println(index);
					return Mono.delay(Duration.ofMillis(index * 1100));
				}).doOnNext(s -> System.out.println("retried at " + LocalTime.now()))).subscribe(System.out::println);
		Thread.sleep(100000);
		
	}

	
	
	
	
}
