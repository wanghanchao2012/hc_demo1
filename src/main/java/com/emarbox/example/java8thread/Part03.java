package com.emarbox.example.java8thread;

import reactor.core.publisher.Flux;

public class Part03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux<String> just = Flux.just("a", "b", "c");
		Flux<String> just1 = Flux.just("1", "2", "3","4");
		Flux.zip(just, just1, (x, d) -> x + d).subscribe(e -> System.out.println(e));
	}

}
