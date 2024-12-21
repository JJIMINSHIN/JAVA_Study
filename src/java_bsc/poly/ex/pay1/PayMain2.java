package java_bsc.poly.ex.pay1;

import java.util.Scanner;

/*
 * 결제 수단 추가시 service부분만 바꾸면 된다!
 */
public class PayMain2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PayService payService = new PayService();

		while (true) {
			System.out.println("결제 수단을 입력하세요: ");
			String payOption = scanner.nextLine();
			
			if (payOption.equals("x")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.print("결제 금액을 입력하세요:");
			int amount = scanner.nextInt();
			scanner.nextLine();
			payService.processPay(payOption, amount);
		}

	}
}
