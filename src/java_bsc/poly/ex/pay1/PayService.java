package java_bsc.poly.ex.pay1;

public class PayService {
	
	private Pay pay;

	public void optPay(Pay pay) {
		System.out.println(pay+" 시스템과 연결합니다.");
		this.pay =pay;
	}
	public void processPay(String option, int amount) {
		System.out.println("결제를 시작합니다: optopn="+option+", amount="+amount);
		
		Pay pay = PayStore.findPay(option);
		boolean result = pay.pay(amount);
		
		if (result) {
			System.out.println("결제가 성공했습니다.");
		} else {
			System.out.println("결제가 실패했습니다.");
		}
	}
}
