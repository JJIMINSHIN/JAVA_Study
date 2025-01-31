package java_mid01.time;

import java.time.*;
import java.time.temporal.*;

public class ChangeTimeWithMain {

	public static void main(String args[]) {
		LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
		System.out.println("dt = " + dt);

		// with는 불변의 특정필드를 바꿀때 사용 -> 새로운 객체 만들어서 반환해줌
		LocalDateTime changedDt1 = dt.with(ChronoField.YEAR, 2020);
		System.out.println("changedDt1 = " + changedDt1);

		LocalDateTime changedDt2 = dt.withYear(2020);
		System.out.println("changedDt2 = " + changedDt2);
		
		// TemporalAdjuster 사용
		// 다음주 금요일
		LocalDateTime with1 = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println("기준 날짜: " + dt);
		System.out.println("다음 금요일: " + with1);

		
		// 이번 달의 마지막 일요일
		LocalDateTime with2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
		System.out.println("같은 달의 마지막 일요일 = " + with2);
	}

}
