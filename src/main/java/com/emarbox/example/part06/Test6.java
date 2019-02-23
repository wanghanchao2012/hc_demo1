package com.emarbox.example.part06;

import reactor.core.publisher.Flux;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {

		Flux<Integer> source = Flux.range(1, 3).doOnSubscribe(s -> System.out.println("subscribed to source"));

		Flux<Integer> autoCo = source.publish().autoConnect(2);

		autoCo.subscribe(System.out::println, e -> {
		}, () -> {
		});
		System.out.println("subscribed first");
		Thread.sleep(500);
		System.out.println("subscribing second");
		autoCo.subscribe(System.out::println, e -> {
		}, () -> {
		});
	}
}
