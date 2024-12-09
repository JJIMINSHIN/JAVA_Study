package java_bsc.ref.ex;

public class ProductOrderMain2 {
	public static void main(String args[]) {
		ProductOrder[] orders = new ProductOrder[3]; 

		orders[0] = createOrder("두부", 2000, 2);
		orders[1] = createOrder("김치", 5000, 1);
		orders[2] = createOrder("콜라", 1500, 2);

		PrintOrders(orders);
		System.out.println("총 결제 금액: "+getToTalAmount(orders));
		
	}
	
	static ProductOrder createOrder(String productName, int price, int quantity) {
		ProductOrder order = new ProductOrder();
		
		order.productName = productName;
		order.price = price;
		order.quantity = quantity;

		return order;
	}
	
	static void PrintOrders(ProductOrder[] orders) {
		for(ProductOrder product : orders) {
			System.out.println("상품명: "+product.productName+", 가격: "+product.price+", 수량: "+product.quantity);
		}
	}
	
	static int getToTalAmount(ProductOrder[] orders) {
		int sum =0;
		for(ProductOrder product : orders) {
			sum += (product.price * product.quantity);
		}
		return sum;
	}
	
	
	
}
