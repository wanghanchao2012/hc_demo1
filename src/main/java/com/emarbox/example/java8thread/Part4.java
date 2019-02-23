package com.emarbox.example.java8thread;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Part4 {

	public static void main(String[] args) {
		Flux.create(sink -> {
			sink.next(Thread.currentThread().getName());
			sink.complete();
		}).publishOn(Schedulers.single()).map(x -> {
			System.out.println("AAA");
			return String.format("[%s] %s", Thread.currentThread().getName(), x);
		})
				.publishOn(Schedulers.elastic()).map(x -> {
					System.out.println("bbbb");
					return String.format("[%s] %s", Thread.currentThread().getName(), x);
				})
				.subscribeOn(Schedulers.parallel()).toStream().forEach(System.out::println);
	}

}
