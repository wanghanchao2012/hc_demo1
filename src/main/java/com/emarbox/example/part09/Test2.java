package com.emarbox.example.part09;

import java.util.function.Function;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> f = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x + 1;
			}
		};
		Function<Integer, Integer> g = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x * 2;
			}
		};
		Function<Integer, Integer> h = f.compose(g);
		int result = h.apply(1);
		System.out.println(result);
	}

}
