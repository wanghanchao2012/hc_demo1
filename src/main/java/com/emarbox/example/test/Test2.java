package com.emarbox.example.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Test2().c();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<String> list = new ArrayList<String>();
		list.add("a1");
		list.add("");
		list.add("a2");
		list.add("a2");
		list.stream().filter(e->StringUtils.hasLength(e)).distinct().forEach(System.out::print);
	}
	
	public void a (){
		throw new IllegalArgumentException("a");
	}
	public void b (){
		a();
	}
	public void c(){
		b();
	}

}
