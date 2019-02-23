package com.emarbox.example.java8thread;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class AAA<U> {
	public static void main(String[] args) {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			return 100;
		});
		CompletableFuture<Integer> handleAsync = future.handleAsync(new BiFunction<Integer, Throwable, Integer>() {
			@Override
			public Integer apply(Integer t, Throwable u) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return t + 1;
			}
		});
		boolean complete;
		do {
			complete = handleAsync.isDone();
			System.out.println(complete);
		} while (complete == false);
	}
}
