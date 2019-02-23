package com.emarbox.example.test;

import java.util.ArrayList;

public class PersonTest {

	public static void main(String[] args) {
		// 买一箱牛奶
		Milk m = new Milk();

		Active haveMeals = m.HaveMeals();
		// 没事喝一瓶
		haveMeals.drink();
		// 有事喝一瓶
		haveMeals.drink();
		// 看看还剩多少？
		m.currentNum();
	}

	public <T extends Object> ArrayList<T> getInfo() {
		return new ArrayList<T>();
	}

}