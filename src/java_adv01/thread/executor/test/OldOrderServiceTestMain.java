package java_adv01.thread.executor.test;

import java.util.concurrent.ExecutionException;

/*
 * 실행 결과 (리패토리 전)
21:05:11.857 [     main] 재고 업데이트: Order#1234 
21:05:12.871 [     main] 배송 시스템 알림: Order#1234 
21:05:13.884 [     main] 회계 시스템 업데이트: Order#1234 
21:05:14.895 [     main] 모든 주문 처리가 성공적으로 완료되었습니다. 
 * */
public class OldOrderServiceTestMain {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		String orderNo = "Order#1234"; // 예시 주문 번호
		OldOrderService orderService = new OldOrderService();
		orderService.order(orderNo);
	}

}
