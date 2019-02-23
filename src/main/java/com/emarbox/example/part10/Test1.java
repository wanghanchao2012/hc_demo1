package com.emarbox.example.part10;

import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux.fromStream(Stream.builder().add(1).add(2).build()).doOnNext(System.out::println)
				.doOnNext(System.out::println).subscribe();
	}

}
