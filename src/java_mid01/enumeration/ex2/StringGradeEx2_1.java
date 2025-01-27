package java_mid01.enumeration.ex2;

public class StringGradeEx2_1 {

	public static void main(String[] args) {
		int price = 10000;

		DiscountService discountService = new DiscountService();
		int basic = discountService.discount(ClassGrade.BASIC, price);
		int gold = discountService.discount(ClassGrade.GOLD, price);
		int diamond = discountService.discount(ClassGrade.DIAMOND, price);
	
		System.out.println("BASIC 등급의 할인 금액: " + basic); //10
		System.out.println("GOLD 등급의 할인 금액: " + gold); //20
		System.out.println("DIAMOND 등급의 할인 금액: " + diamond); //30
		
	
	}

}
