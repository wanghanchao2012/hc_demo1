package com.emarbox.example.part06;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Flux<Integer> source = Flux.range(1, 3).doOnSubscribe(s -> System.out.println("subscribed to source"));

		ConnectableFlux<Integer> co = source.publish();

		co.subscribe(System.out::println, e -> {
		}, () -> {
		});
		co.subscribe(System.out::println, e -> {
		}, () -> {
		});

		System.out.println("done subscribing");
		Thread.sleep(500);
		System.out.println("will now connect");

		co.connect();
	}

}
