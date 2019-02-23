package com.emarbox.example.part10;

import java.io.File;

import scala.collection.immutable.List;
import scala.io.Codec;
import scala.io.Source;

public class Test5 {

	public static void main(String[] args) {
		List<String> list = Source.fromFile(new File("D:\\head_info.txt"), "utf-8").getLines().toList();
		System.out.println(list);
	}

}
