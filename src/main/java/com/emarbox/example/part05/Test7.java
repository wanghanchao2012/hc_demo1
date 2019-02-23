package com.emarbox.example.part05;

import java.util.concurrent.atomic.LongAdder;

import reactor.core.publisher.Flux;

public class Test7 {

	public static void main(String[] args) throws InterruptedException {
		LongAdder statsCancel = new LongAdder();
		Flux.create((sink) -> {
			sink.next("ss");
			sink.complete();
		}).doFinally(e -> {
			statsCancel.increment();
		}).subscribe(e -> {ssss();
		}, error -> System.out.println("saveConfig error :{} " + error));
		System.out.println(statsCancel.intValue());
	}

	public static String ssss() {
		String a = null;
		a.toCharArray();
		return "a";
	}

}
