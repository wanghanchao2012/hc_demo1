package com.emarbox.example.part03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
		Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
		System.out.println(outputStream.collect(Collectors.toList()));

		Stream<String> map = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase);

		map.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
	}

}
