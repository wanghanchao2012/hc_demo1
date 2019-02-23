package com.emarbox.example.part06;

import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnicastProcessor<String> hotSource = UnicastProcessor.create();

		Flux<String> hotFlux = hotSource.publish().autoConnect().map(String::toUpperCase);

		hotFlux.subscribe(d -> System.out.println("Subscriber 1 to Hot Source: " + d));

		hotSource.onNext("blue");
		hotSource.onNext("green");

		hotFlux.subscribe(d -> System.out.println("Subscriber 2 to Hot Source: " + d));

		hotSource.onNext("orange");
		hotSource.onNext("purple");
		hotSource.onComplete();
	}

}
