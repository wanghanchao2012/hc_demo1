package com.emarbox.example.part01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestMain {
	public static void main(String[] args) {
		List<Person> roster = new ArrayList<>();
		Person p1 = new Person("zhangsan", LocalDate.now(), Person.Sex.MALE, "zhangsan@emar.com", 22);
		Person p2 = new Person("lisi", LocalDate.now(), Person.Sex.FEMALE, "lisi@emar.com", 33);
		Person p3 = new Person("wangwu", LocalDate.now(), Person.Sex.MALE, "wangwu@emar.com", 23);
		roster.add(p1);
		roster.add(p2);
		roster.add(p3);
		double average = roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).mapToInt(Person::getAge)
				.average().getAsDouble();
		Integer totalAge = roster.stream().mapToInt(Person::getAge).sum();
		Integer totalAgeReduce = roster.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);
		System.out.println(average);
		System.out.println(totalAge);
		System.out.println(totalAgeReduce);

		Averager averageCollect = roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).map(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);

		System.out.println("Average age of male members: " + averageCollect.average());
		List<String> stringStream = new ArrayList<>();
		stringStream.add("a");
		stringStream.add("b");
		Stream<String> stream = stringStream.stream();
	     List<String> asList = stream.collect(ArrayList::new, ArrayList::add,
                 ArrayList::addAll);
	     System.out.println(asList);

	}

}
