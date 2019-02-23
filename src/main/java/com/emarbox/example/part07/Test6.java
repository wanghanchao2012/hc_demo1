package com.emarbox.example.part07;

import java.util.Optional;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public class Test6 {

	static final String HTTP_CORRELATION_ID = "reactive.http.library.correlationId";

	public static void main(String[] args) {
		doPut("http://www.baidu.com", Mono.just("1")).subscribe(System.out::println);
	}

	private static Mono<Tuple2<Integer, String>> doPut(String url, Mono<String> data) {
		Mono<Tuple2<String, Optional<Object>>> dataAndContext = data
				.zipWith(Mono.subscriberContext().map(c -> c.getOrEmpty(HTTP_CORRELATION_ID)));

		return dataAndContext.<String> handle((dac, sink) -> {
			if (dac.getT2().isPresent()) {
				sink.next("PUT <" + dac.getT1() + "> sent to " + url + " with header X-Correlation-ID = "
						+ dac.getT2().get());
			} else {
				sink.next("PUT <" + dac.getT1() + "> sent to " + url);
			}
			sink.complete();
		}).map(msg -> Tuples.of(200, msg));
	}
}
