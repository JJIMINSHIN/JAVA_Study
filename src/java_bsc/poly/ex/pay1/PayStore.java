package java_bsc.poly.ex.pay1;

/*
 * static으로 한 이유 : 객쳇 생성 불가능하게 하려고
 */
public abstract class PayStore {
	
	// 결제 수단 추가시 변하는 부분
	public static Pay findPay(String option) {
		if (option.equals("kakao")) {
			return new KakaoPay();
		} else if (option.equals("naver")) {
			return new NaverPay();
		} else if (option.equals("kg")) { //임의로 추가해봄
			return new KGsignPay();
		} 
		else {
			return new DefaultPay();
		}
	}
}
