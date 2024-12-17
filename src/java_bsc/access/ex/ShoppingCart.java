package java_bsc.access.ex;

public class ShoppingCart {
	private Item[] items = new Item[10];
	private int itemCount;

	public void addItem(Item item) { // name, price, quantity값이 객체로 들어옴
		if (itemCount >= items.length) {
			System.out.println("장바구니가 가득 찼습니다.");
			return;
		}
		items[itemCount] = item;
		itemCount++;

	}

	public void displayItems() {
		System.out.println("장바구니 상품 출력");
		for (int i = 0; i < itemCount; i++) {
			Item item = items[i];
			System.out.println("상품명: " + item.getName() + ", 합계: " + item.getTotalPrice());

		}
		System.out.println("전체 가격 합:" + getSumPrice());
	}

	private int getSumPrice() {
		int sum = 0;
		for (int i = 0; i < itemCount; i++) {
			Item item = items[i];
			sum += item.getTotalPrice();
		}
		return sum;
	}

}
