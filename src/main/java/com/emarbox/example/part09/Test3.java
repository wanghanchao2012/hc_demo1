package com.emarbox.example.part09;

import java.util.function.Function;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		String apply = transformationPipeline.apply("xx");
		System.out.println(apply);
	}

}
