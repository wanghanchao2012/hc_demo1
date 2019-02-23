package com.emarbox.example.part08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class TestA {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);

		List<Integer> uidList = new ArrayList<Integer>();
		uidList = Stream.of(4, 3, 2, 1, 40, 30, 20, 10, 400, 300, 200, 100).collect(Collectors.toList());
		Flux.<Integer> fromIterable(uidList).groupBy(accountId -> accountId % 5).collectList().block()
				.forEach(e -> System.out.println(e.collectList().block()));
		System.out.println("---------------------------------");
		Flux.<Integer> fromIterable(uidList).groupBy(accountId -> accountId % 5)
		.flatMap(accoutGroup -> {
			Mono<List<Integer>> collectList = accoutGroup.collectList();
			Mono<List<Integer>> map = accoutGroup
			.collectList()
			.publishOn(Schedulers.elastic())
			.map(accountBatch -> accountBatch);
			return map;
		})
		.publishOn(Schedulers.single()).subscribe(e->{
			System.out.println(e);
		});
		
		System.out.println("|||||||||||||||||||||||||||||||||");
		Flux.<Integer> fromIterable(uidList).groupBy(accountId -> accountId % 5)
	 .subscribe(e->{
			System.out.println(e.collectList().block());
		});

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
