package com.emarbox.example.part05;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import reactor.core.publisher.Flux;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		List<String> data = new ArrayList<String>(Arrays.asList("{A}", "{B}", "{C}"));
		Flux<String> intervalFlux1 = Flux
									.interval(Duration.ofMillis(500))
									.map(tick -> {
										if (tick < data.size())
											return "item " + tick + ": " + data.get(tick.intValue());
										return "Done (tick == data.size())";
									});
		 
		intervalFlux1.take(data.size() + 1).subscribe(System.out::println);
		Thread.sleep(3000);
	}

}
