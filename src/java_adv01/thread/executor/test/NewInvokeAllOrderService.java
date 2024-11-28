package java_adv01.thread.executor.test;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.List;
import java.util.concurrent.*;

import java_adv01.thread.executor.CallableTask;

public class NewInvokeAllOrderService {
	public void order(String orderNo) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);

		InventoryWork inventoryWork = new InventoryWork(orderNo);
		ShippingWork shippingWork = new ShippingWork(orderNo);
		AccountingWork accountingWork = new AccountingWork(orderNo);

		
		List<Callable<Boolean>> tasks = List.of(inventoryWork, shippingWork, accountingWork);
		List<Future<Boolean>> futures = es.invokeAll(tasks);
		
		Boolean value = true;
		for (Future<Boolean> future : futures) {
			value = future.get();
		}
		
		// 결과 확인
		if (value) {
			log("모든 주문 처리가 성공적으로 완료되었습니다.");
		} else {
			log("일부 작업이 실패했습니다.");
		}
		es.close();
	}

	static class InventoryWork implements Callable<Boolean>{

		private final String orderNo;

		public InventoryWork(String orderNo) {
			this.orderNo = orderNo;
		}

		public Boolean call() {
			log("재고 업데이트: " + orderNo);
			sleep(1000);
			return true;
		}
	}

	static class ShippingWork implements Callable<Boolean> {
		private final String orderNo;

		public ShippingWork(String orderNo) {
			this.orderNo = orderNo;
		}

		public Boolean call() {
			log("배송 시스템 알림: " + orderNo);
			sleep(1000);
			return true;
		}
	}

	static class AccountingWork implements Callable<Boolean> {
		private final String orderNo;

		public AccountingWork(String orderNo) {
			this.orderNo = orderNo;
		}

		public Boolean call() {
			log("회계 시스템 업데이트: " + orderNo);
			sleep(1000);
			return true;
		}
	}

}
