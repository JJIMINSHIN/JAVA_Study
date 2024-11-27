package java_bsc.class1.ex;

public class ProductOrderMain {
	public static void main(String args[]) {
		ProductOrder[] products = new ProductOrder[3];
		
		int sum =0;
		
		
		ProductOrder product1 = new ProductOrder();
		product1.productName ="두부";
		product1.price = 2000;
		product1.quantity = 2;
		products[0] = product1;
		
		ProductOrder product2 = new ProductOrder();
		product2.productName ="김치";
		product2.price = 5000;
		product2.quantity = 1;
		products[1] = product2;
		
		ProductOrder product3 = new ProductOrder();
		product3.productName ="콝라";
		product3.price = 1500;
		product3.quantity = 2;
		products[2] = product3;
		

		for(ProductOrder od : products) {
			sum += (od.price * od.quantity);
			System.out.println("상품명: "+od.productName+", 가격: "+od.price+", 수량: "+od.quantity);
		}
		System.out.println("총 결제 금액: "+sum);
		
	}
}
