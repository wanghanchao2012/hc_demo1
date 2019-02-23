package com.emarbox.example.part09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action", "3");
		List<Object> collect = words.stream()
				.collect(Collectors.collectingAndThen(Collectors.mapping(e -> e.length(), Collectors.toList()),
						e -> e.stream().collect(Collectors.toList())));
		System.out.println(collect);

	}
}
