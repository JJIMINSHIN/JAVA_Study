package java_mid01.enumeration.ref2;

public class DiscountService {
	
	public int discount(Grade classGrade, int price) {
		return price * classGrade.getDiscountPercent() / 100;
	}

}
