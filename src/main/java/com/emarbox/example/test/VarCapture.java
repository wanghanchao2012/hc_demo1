package com.emarbox.example.test;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VarCapture {

	static int num = 10;

	public static void main(String[] args) {

		System.out.println(Stream.of("a", "b", "c")
				.collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toMap( e->e, e->e))));

	}

}

interface MyFunc {
	int func(int n);
}