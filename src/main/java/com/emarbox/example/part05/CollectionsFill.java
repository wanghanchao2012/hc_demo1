package com.emarbox.example.part05;

import java.util.*;

public class CollectionsFill {
	public static void main(String args[]) {
		ArrayList myList = new ArrayList();
		myList.add(50);
		myList.add(10);
		myList.add(20);
		myList.add(40);
		System.out.println("Elements before fill: " + myList);

		Collections.fill(myList, 0);
		System.out.println("Elements after fill: " + myList);

		ArrayList namesList = new ArrayList();
		namesList.add("hello");
		namesList.add("world");
		namesList.add(20);
		System.out.println("\nElements before fill: " + namesList);

		Collections.fill(namesList, null);
		System.out.println("Elements after fill: " + namesList);
	}
}