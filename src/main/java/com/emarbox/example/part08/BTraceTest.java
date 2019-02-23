package com.emarbox.example.part08;

public class BTraceTest {
	public String sayHello(String name, int age) {
		return "hello everyone";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sayHello = new BTraceTest().sayHello("zhangsna", 33);
		System.out.println(sayHello);
		
	}

}
