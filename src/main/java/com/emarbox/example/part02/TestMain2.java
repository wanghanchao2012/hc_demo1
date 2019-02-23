package com.emarbox.example.part02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.emarbox.example.part01.Person;

public class TestMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> roster = new ArrayList<>();
		Person p1 = new Person("zhangsan", LocalDate.now(), Person.Sex.MALE, "zhangsan@emar.com", 22);
		Person p2 = new Person("lisi", LocalDate.now(), Person.Sex.FEMALE, "lisi@emar.com", 33);
		Person p3 = new Person("wangwu", LocalDate.now(), Person.Sex.MALE, "wangwu@emar.com", 23);
		roster.add(p1);
		roster.add(p2);
		roster.add(p3);
		Map<Person.Sex, Double> averageAgeByGender = roster.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge)));
		System.out.println(averageAgeByGender);

		double average = roster.parallelStream().filter(p -> p.getGender() == Person.Sex.MALE).mapToInt(Person::getAge)
				.average().getAsDouble();
		System.out.println(average);

		Map<Person.Sex, List<Person>> byGender = roster.stream().collect(Collectors.groupingBy(Person::getGender));
		System.out.println(byGender);
		ConcurrentMap<Person.Sex, List<Person>> byGender1 = roster.parallelStream()
				.collect(Collectors.groupingByConcurrent(Person::getGender));
		System.out.println(byGender1);

	}

}
