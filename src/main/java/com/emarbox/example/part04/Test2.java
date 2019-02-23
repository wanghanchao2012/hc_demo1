package com.emarbox.example.part04;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class Test2 {

	public static void main(String[] args) {
		List<String> views = Lists.newArrayList("wsbs", "xafaswzx", "b8fw", "ad");
		Optional<String> res = views.stream().collect(Collectors.minBy(Comparator.comparing(String::length)));
		System.out.println(res.get()); // ad

	}

}
