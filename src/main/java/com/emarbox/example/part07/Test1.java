package com.emarbox.example.part07;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

public class Test1 {

	public static void main(String[] args) {
		Flux<GroupedFlux<String, Integer>> groupBy = Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13)
				.groupBy(i -> i % 2 == 0 ? "even" : "odd");
		List<GroupedFlux<String, Integer>> block = groupBy.collectList().block();
		block.stream().forEach(e -> {
			System.out.println(e.key());
			e.collectList().block().stream().forEach(System.out::println);
		});
	}

}
