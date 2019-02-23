package com.emarbox.example.part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> listOfStrings = new ArrayList<>();
			listOfStrings.add("one");
			listOfStrings.add("two");

			// This will fail as the peek operation will attempt to add the
			// string "three" to the source after the terminal operation has
			// commenced.
			String concatenatedString = listOfStrings.stream()
					// Don't do this! Interference occurs here.
					.peek(s -> listOfStrings.add("three")).reduce((a, b) -> a + " " + b).get();

			System.out.println("Concatenated string: " + concatenatedString);

		} catch (Exception e) {
			System.out.println("Exception caught: " + e.toString());
		}

		List<Integer> serialStorage = new ArrayList<>();
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

		System.out.println("Serial stream:");
		listOfIntegers.stream()

				// Don't do this! It uses a stateful lambda expression.
				.map(e -> {
					serialStorage.add(e);
					return e;
				})

				.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println(serialStorage);

		serialStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("Parallel stream:");
		List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
		listOfIntegers.parallelStream().map(e -> {
			parallelStorage.add(e);
			return e;
		}).forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

	}

}
