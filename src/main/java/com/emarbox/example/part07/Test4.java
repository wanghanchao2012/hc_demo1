package com.emarbox.example.part07;

import reactor.core.publisher.Mono;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "message";
		Mono.just("Hello").flatMap(s -> Mono.subscriberContext().map(ctx -> s + " " + ctx.get(key))).subscribe(System.out::println);
		Mono<String> r = Mono.just("Hello").flatMap(s -> Mono.subscriberContext().map(ctx -> s + " " + ctx.get(key)))
				.subscriberContext(ctx -> ctx.put(key, "World"));
		r.subscribe(System.out::println);
	}

}
