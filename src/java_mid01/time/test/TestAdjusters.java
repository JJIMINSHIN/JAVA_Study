package java_mid01.time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TestAdjusters {
	public static void main(String[] args) {
		int year = 2024;
		int month = 1;
		
		LocalDate date = LocalDate.of(year, month, 1);
		DayOfWeek fDay = date.getDayOfWeek();
		DayOfWeek lDay = date.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek();
		
		System.out.println("firstDayOfWeek = " + fDay);
		System.out.println("lastDayOfWeek = " + lDay);

		
		
	}
}