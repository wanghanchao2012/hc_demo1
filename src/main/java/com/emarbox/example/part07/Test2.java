package com.emarbox.example.part07;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Test2 {
	public static void main(String[] args) {

		Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13).windowUntil(i -> {
			return false;
		}).collectList().block().stream().forEach(e -> {
			System.out.println(e.collectList().block());
			System.out.println("---------");
		});
	}
}
