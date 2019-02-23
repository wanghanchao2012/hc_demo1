package com.emarbox.example.part03;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stream stream = Stream.of("a", "b", "c");
		String str = stream.collect(Collectors.joining("-", "[", "]")).toString();
		System.out.println(str);
		Stream<String> streamBuilder = Stream.<String> builder().add("a").add("b").add("c").build();
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		System.out.println(streamBuilder.collect(Collectors.toList()).toString());
		System.out.println(streamIterated.collect(Collectors.toList()).toString());
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		intStream.forEach(e -> System.out.println(e));
		System.out.println("---------------------");
		longStream.forEach(e -> System.out.println(e));
		System.out.println("---------------------");
		IntStream streamOfChars = "abc".chars();
		streamOfChars.forEach(e -> System.out.println(e));
		Path path = Paths.get("C:\\file.txt");
		Stream<String> streamOfStrings = Files.lines(path);
		Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
		System.out.println("---------------------");
		System.out.println(streamOfStrings);
		streamOfStrings.forEach(e -> System.out.println(e));
		System.out.println("---------------------");

		streamWithCharset.forEach(e -> System.out.println(e));
	}
}
