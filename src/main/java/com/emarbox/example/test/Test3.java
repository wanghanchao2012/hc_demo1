package com.emarbox.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
//		list1.stream().collect(Collectors.groupingBy(e->String.valueOf(e).length(),e->String.valueOf(e)));
//		System.out.println(collect);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8);
		numbers.stream()
		       .forEachOrdered(System.out::println);  
	}

}
