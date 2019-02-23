package com.emarbox.example.java8thread;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import reactor.core.publisher.Flux;

public class Part01 {

	public static void main(String[] args) {
		try {
			new Part01().testSimpleOperators();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testSimpleOperators() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1); // 2
		Flux.zip(getZipDescFlux(), Flux.interval(Duration.ofMillis(200))) // 3
				.subscribe(t -> {
					System.out.println(t.getT1());
				}, null, countDownLatch::countDown); // 4
		countDownLatch.await(10, TimeUnit.SECONDS); // 5
	}

	private Flux<String> getZipDescFlux() {
		String desc = "Zip two sources together, that is to say wait for all the sources to emit one element and combine these elements once into a Tuple2.";
		return Flux.fromArray(desc.split("\\s+")); // 1
	}
}
