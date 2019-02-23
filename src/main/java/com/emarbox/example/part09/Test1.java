package com.emarbox.example.part09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Test1 {

	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList();
		inventory.add(new Apple(4));
		inventory.add(new Apple(1));
		inventory.add(new Apple(2));
		new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		inventory.sort(Comparator.comparing(Apple::getWeight));
		for (Apple apple : inventory) {
			System.out.println(apple.getWeight());
		}

		BiPredicate<List<String>, String> bip = List::contains;
		BiPredicate<List<String>, String> bip1 = (List<String> list, String key) -> list.contains(key);

		Function<String, Integer> stringToInteger = (String e) -> Integer.parseInt(e);
		Function<String, Integer> stringToInteger1 = Integer::parseInt;
	}
}
