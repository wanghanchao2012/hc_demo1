package com.emarbox.example.part10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Test3 {

	public static void main(String[] args) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
				.appendText(ChronoField.YEAR)
				.appendLiteral("-")
				.appendText(ChronoField.MONTH_OF_YEAR)
				.appendLiteral("-")
				.appendText(ChronoField.DAY_OF_MONTH)
				.appendLiteral(" ")
				.appendText(ChronoField.HOUR_OF_DAY)
				.appendLiteral(":")
				.appendText(ChronoField.MINUTE_OF_HOUR)
				.appendLiteral(":")
				.appendText(ChronoField.SECOND_OF_MINUTE)
				.toFormatter(Locale.CHINESE);
		// TODO Auto-generated method stub
		LocalDateTime time = LocalDateTime.now();
		String format = time.format(ofPattern);
		System.out.println(format);
	}

}
