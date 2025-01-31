package java_mid01.time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/*
 * LocalDate에는 년월일만 있는데 시분초를 꺼낸다면 아래와 같은 에러 터짐
 * Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: SecondOfMinute
 */
public class IsSupportedMain2 {
	public static void main(String args[]) {
		LocalDate now = LocalDate.now();
		int minute = now.get(ChronoField.SECOND_OF_MINUTE);
		System.out.println("minute = " + minute);
	}

}
