package com.emarbox.example.part02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.emarbox.example.part01.Person;

public class TestMain {

	public static void main(String[] args) {
		List<Person> roster = new ArrayList<>();
		Person p1 = new Person("zhangsan", LocalDate.now(), Person.Sex.MALE, "zhangsan@emar.com", 22);
		Person p2 = new Person("lisi", LocalDate.now(), Person.Sex.FEMALE, "lisi@emar.com", 33);
		Person p3 = new Person("wangwu", LocalDate.now(), Person.Sex.MALE, "wangwu@emar.com", 23);
		roster.add(p1);
		roster.add(p2);
		roster.add(p3);
		Map<Person.Sex, List<String>> namesByGender = roster.stream().collect(
				Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println(namesByGender);
		Collectors.reducing(new BinaryOperator<String>() {
			@Override
			public String apply(String t, String u) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		Map<Person.Sex, Integer> totalAgeByGender = roster.stream().collect(
				Collectors.groupingBy(Person::getGender, Collectors.reducing(0,t -> t.getAge(), (t, u) -> t+u)));
		System.out.println(totalAgeByGender);
//		Map<Person.Sex, Integer> totalAgeByGender = roster.stream().collect(
//				Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
//		System.out.println(totalAgeByGender);
	}

}
