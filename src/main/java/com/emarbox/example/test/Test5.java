package com.emarbox.example.test;

import java.util.concurrent.CompletableFuture;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return 1;
		}).thenApplyAsync(arg0 -> {
			System.out.println(Thread.currentThread().getName());
			return arg0 + "";
		}).thenCompose(f -> CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return f + 2;
		})).thenCombine(CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return 2 + "";
		}), (arg0, arg1) -> Integer.parseInt(arg0 + arg1)).thenAccept(e -> System.out.println(e));
	}

}
