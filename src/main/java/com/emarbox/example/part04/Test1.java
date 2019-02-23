package com.emarbox.example.part04;

import java.util.Optional;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
		stream.forEach(e -> System.out.println(e));
//		Optional<String> anyElement = stream.findAny();
//		System.out.println(anyElement.get());
		Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
		onceModifiedStream.forEach(e->System.out.println(e));
	}

}
