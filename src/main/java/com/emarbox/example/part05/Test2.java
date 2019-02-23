package com.emarbox.example.part05;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		 Flux.just("0","1","2").delayElements(Duration.ofSeconds(10)).subscribe(System.out::print);
		 Thread.sleep(100000);
	}

}
