package com.emarbox.example.part10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Test6 {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> collect = Stream.of(1, 3, 4, 5, 6, 7, 8, 9, 54, 62, 34).collect(Collectors.toList());
		Flux.create(t -> {
			System.out.println("create=" + Thread.currentThread().getName());
			t.next(collect);
			t.complete();
		})
		.groupBy(e->e)
		.publishOn(Schedulers.elastic())
		.subscribeOn(Schedulers.parallel())
		.map(e -> {
			System.out.println("map=" + Thread.currentThread().getName());
			return e;
		}).subscribe(e -> {
			System.out.println("subscribe=" + Thread.currentThread().getName());
			System.out.println(e);
		});
		Thread.sleep(30000);
	}

}
