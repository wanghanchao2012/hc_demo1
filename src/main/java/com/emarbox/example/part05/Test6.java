package com.emarbox.example.part05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import reactor.core.publisher.Flux;

public class Test6 {
	public void get(){
	} 
	public static void main(String[] args) throws InterruptedException {
		Callable<List<String>> callable = new Callable<List<String>>() {
			@Override
			public List<String> call() throws Exception {
				List<String> list = new ArrayList<String>();
				list.add("a");
				list.add("b");
				list.add("c");
				return list;
			}
		};
		AtomicLong atomicLong = new AtomicLong();
		Flux<List<String>> flux = Flux.generate(Test6::new, (state, sink) -> {
			state.get();
			sink.complete();
			return state;
		});
		flux.subscribe(System.out::println);
		Thread.sleep(100000);
	}

}
