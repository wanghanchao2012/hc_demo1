package com.emarbox.example.part05;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

public class Test8 {
	public static void main(String[] args) {
		Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> t) {
				t.success("xx");
			}
		}).subscribe(System.out::print);
	}
}
