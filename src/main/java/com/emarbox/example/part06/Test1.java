package com.emarbox.example.part06;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Test1 {

	public static void main(String[] args) {
		Flux.just("foo", "bar").checkpoint("bbbbbbbbbb").concatWith(Mono.error(new IllegalArgumentException("boom"))).checkpoint("eeeeeeeee").subscribe(System.out::print);
	}

	public static <T> Flux<T> appendBoomError(Flux<T> source) {
		return source.concatWith(Mono.error(new IllegalArgumentException("boom")));
	}
}
