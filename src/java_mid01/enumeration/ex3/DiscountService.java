package java_mid01.enumeration.ex3;

import static java_mid01.enumeration.ex3.Grade.*;

public class DiscountService {

	public int discount(Grade grade, int price) {
		int discountPercent = 0;
		// Grade.BASIC -> static으로 뺴서 간결하게 할 수 있음
		if (grade == BASIC) {
			discountPercent = 10;
		} else if (grade == GOLD) {
			discountPercent = 20;
		} else if (grade == DIAMOND) {
			discountPercent = 30;
		} else {
			System.out.println(grade + ": 할인X");
		}
		return price * discountPercent / 100;
	}
}
