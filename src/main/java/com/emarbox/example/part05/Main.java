package com.emarbox.example.part05;

import reactor.core.publisher.Flux;

public class Main {
	public static void main(String[] args) throws Exception {
		Flux.range(1, 6).map(i -> 10 / (3 - i)).retry(3).subscribe(System.out::println, System.err::println);
		Thread.sleep(100); // 确保序列执行完
	}
}
