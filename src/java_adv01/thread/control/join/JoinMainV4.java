package java_adv01.thread.control.join;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 순서
23:40:37.390 [     main] Start 
23:40:37.416 [     main] join() - main 스레드가 thread1 종료까지 1초 대기 
23:40:37.416 [ thread-1] 작업 시작 
23:40:38.427 [     main] main  스레드 대기 완료 
23:40:38.452 [     main] task1.result = 0 
23:40:38.454 [     main] End 
23:40:39.435 [ thread-1] 작업 완료 result = 1275 
 * */
public class JoinMainV4 {
	
	public static void main(String args[]) throws InterruptedException {
		log("Start");
		
		SumTask task1 = new SumTask(1,50);		
		Thread thread1 = new Thread(task1, "thread-1");
		
		thread1.start();
		
		// 스레드가 종료될때 까지 대기
		log("join() - main 스레드가 thread1 종료까지 1초 대기");
		thread1.join(1000);
		log("main  스레드 대기 완료");
		
		
		log("task1.result = "+task1.result);
		
		log("End");
	}
	
	static class SumTask implements Runnable{
		int startValue;
		int endValue;
		int result = 0;
		
		public SumTask(int startValue, int endValue) {
			this.startValue = startValue;
			this.endValue = endValue;
		}
		
		@Override
		public void run() {
			log("작업 시작");
			sleep(2000);
			int sum=0;
			for(int i=startValue; i<=endValue; i++) {
				sum += i;
			}
			result = sum;
			log("작업 완료 result = "+result);
			
		}
	}

}
