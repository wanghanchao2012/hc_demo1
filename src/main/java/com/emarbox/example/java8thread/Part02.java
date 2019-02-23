package com.emarbox.example.java8thread;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part02 {
	public static void main(String[] args) {

		Mono<String> mono1 = Mono.just("JavaSampleApproach.com");
		Mono<String> mono2 = Mono.just("|Java Technology");
		Mono<String> mono3 = Mono.just("|Spring Framework");

		Flux<String> flux1 = Flux.just("{1}", "{2}", "{3}", "{4}");
		Flux<String> flux2 = Flux.just("|A|", "|B|", "|C|");

		// FLux emits item each 500ms
		Flux<String> intervalFlux1 = Flux.interval(Duration.ofMillis(500)).zipWith(flux1, (i, string) -> string);

		// FLux emits item each 700ms
		Flux<String> intervalFlux2 = Flux.interval(Duration.ofMillis(700)).zipWith(flux2, (i, string) -> string);
 
		Flux.merge(intervalFlux1, intervalFlux2).log().subscribe(System.out::print);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
