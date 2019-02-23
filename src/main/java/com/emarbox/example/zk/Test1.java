package com.emarbox.example.zk;

import java.util.stream.IntStream;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.range(1, 10).forEach(System.out::println);
		System.out.println("-------------------------------");
		IntStream.rangeClosed(1, 3).forEach(System.out::println);
	}

}
