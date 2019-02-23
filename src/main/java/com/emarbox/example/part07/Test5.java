package com.emarbox.example.part07;

import reactor.core.publisher.Mono;

public class Test5 {

	public static void main(String[] args) {
		String key = "message";
		Mono<String> r = Mono.just("Hello").flatMap(s -> Mono.subscriberContext().map(ctx -> s + " " + ctx.get(key)))
				.flatMap(s -> Mono.subscriberContext().map(ctx -> s + " " + ctx.get(key))
						.subscriberContext(ctx -> ctx.put(key, "Reactor")))
				.subscriberContext(ctx -> ctx.put(key, "World")).log();
		r.subscribe(System.out::println);
	}

}
