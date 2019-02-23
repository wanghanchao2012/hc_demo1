package com.emarbox.example.part10;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// TODO Auto-generated method stub
		String date1 = "2018-09-10";
		String date2 = "2018-09-17";
		int between = Period.between(LocalDate.parse(date1, ofPattern), LocalDate.parse(date2, ofPattern)).getDays();
		System.out.println(between);

		LocalDate parse = LocalDate.parse(date1, ofPattern);
		while (parse.compareTo(LocalDate.parse(date2, ofPattern)) <= 0) {
			parse = parse.plusDays(1L);
			System.out.println(parse);
		}
	}

}
