package java_bsc.ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("입력할 주문의 개수를 입력하세요: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		ProductOrder[] orders = new ProductOrder[n];

		for (int i = 0; i < n; i++) {
			
			System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");
			System.out.print("상품명: ");
			
			String productName = scanner.nextLine();
			System.out.print("가격: ");
			
			int price = scanner.nextInt();
			System.out.print("수량: ");
			
			int quantity = scanner.nextInt();
			scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드
			
			orders[i] = createOrder(productName, price, quantity);
		}

		PrintOrders(orders);
		System.out.println("총 결제 금액: " + getToTalAmount(orders));

	}

	static ProductOrder createOrder(String productName, int price, int quantity) {
		ProductOrder order = new ProductOrder();

		order.productName = productName;
		order.price = price;
		order.quantity = quantity;

		return order;
	}

	static void PrintOrders(ProductOrder[] orders) {
		for (ProductOrder product : orders) {
			System.out.println("상품명: " + product.productName + ", 가격: " + product.price + ", 수량: " + product.quantity);
		}
	}

	static int getToTalAmount(ProductOrder[] orders) {
		int sum = 0;
		for (ProductOrder product : orders) {
			sum += (product.price * product.quantity);
		}
		return sum;
	}

}
