package com.emarbox.example.part05;

import reactor.core.publisher.Flux;

public class Part6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux.just(1, 2, 3, 4, 5, 6).takeWhile(e -> {
			return e < 5;
		}).subscribe(System.out::println);
	}

}
