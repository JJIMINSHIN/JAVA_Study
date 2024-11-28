package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 실행 결과
19:18:04.900 [     main] Start 
19:18:04.926 [pool-1-thread-1] 작업 시작 
19:18:04.926 [pool-1-thread-2] 작업 시작 
19:18:06.963 [pool-1-thread-2] 작업 완료 result = 3775 
19:18:06.964 [pool-1-thread-1] 작업 완료 result = 1275 
19:18:06.968 [     main] task1.result = 1275 
19:18:06.970 [     main] task2.result = 3775 
19:18:06.971 [     main] task1 + task2 = 5050 
19:18:06.972 [     main] End 
 * 
 * */
public class SumTaskMainV2 {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		log("Start");
		
		SumTask task1 = new SumTask(1,50);
		SumTask task2 = new SumTask(51,100);
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future<Integer> future1 = es.submit(task1);
		Future<Integer> future2 = es.submit(task2);
		
		Integer sum1 = future1.get();
		Integer sum2 = future2.get();
		
		log("task1.result = "+sum1);
		log("task2.result = "+sum2);
		
		int sumAll = sum1+sum2;
		log("task1 + task2 = "+sumAll);
		log("End");
		
		es.close();
	}
	
	static class SumTask implements Callable<Integer>{
		int startValue;
		int endValue;
		int result = 0;
		
		public SumTask(int startValue, int endValue) {
			this.startValue = startValue;
			this.endValue = endValue;
		}
		
		@Override
		public Integer call() throws InterruptedException{
			log("작업 시작");
			sleep(2000);
			int sum=0;
			for(int i=startValue; i<=endValue; i++) {
				sum += i;
			}
			log("작업 완료 result = "+sum);
			return sum;
			
		}
	}

}
