package com.emarbox.example.part10;

import java.util.List;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionParser parser = new SpelExpressionParser();

		// evals to "Hello World"
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue(); 

		double avogadrosNumber  = (Double) parser.parseExpression("6.0221415E+23").getValue();  
		System.out.println(helloWorld);
		System.out.println(avogadrosNumber);
		List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(parser); 
		for (Object object : listOfLists) {
			System.out.println(object);
		}
	
	}

}
