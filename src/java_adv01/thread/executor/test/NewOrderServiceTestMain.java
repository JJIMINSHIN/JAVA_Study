package java_adv01.thread.executor.test;

import java.util.concurrent.ExecutionException;

/*
 * 실행 결과 
21:13:06.072 [pool-1-thread-3] 회계 시스템 업데이트: Order#1234 
21:13:06.072 [pool-1-thread-2] 배송 시스템 알림: Order#1234 
21:13:06.072 [pool-1-thread-1] 재고 업데이트: Order#1234 
21:13:07.093 [     main] 모든 주문 처리가 성공적으로 완료되었습니다. 
 * */
public class NewOrderServiceTestMain {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		String orderNo = "Order#1234"; // 예시 주문 번호
		NewOrderService orderService = new NewOrderService();
		orderService.order(orderNo);
	}

}
