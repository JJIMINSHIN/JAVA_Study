package java_mid01.time;

import java.time.temporal.ChronoField;

public class ChronoFieldMain {

	public static void main(String args[]) {
		ChronoField[] values = ChronoField.values();
		for (ChronoField value : values) {
			System.out.println(value + ", range = " + value.range()); //항목별 범위
		}

		System.out.println("MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range());
		System.out.println("DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());
	
	}

}
