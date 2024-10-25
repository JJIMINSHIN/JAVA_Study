package java_adv01.thread.control.join;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 순서
23:34:45.670 [     main] Start 
23:34:45.679 [ thread-1] 작업 시작 
23:34:45.679 [     main] join() - main 수래두거 tgread1, thread2 종료까지 대기 
23:34:45.679 [ thread-2] 작업 시작 
23:34:47.713 [ thread-2] 작업 완료 result = 3775 
23:34:47.713 [ thread-1] 작업 완료 result = 1275 
23:34:47.715 [     main] main  스레드 대기 완료 
23:34:47.717 [     main] task1.result = 1275 
23:34:47.718 [     main] task2.result = 3775 
23:34:47.719 [     main] task1 + task2 = 5050 
23:34:47.720 [     main] End 

 * 
 * */
public class JoinMainV3 {
	
	public static void main(String args[]) throws InterruptedException {
		log("Start");
		
		SumTask task1 = new SumTask(1,50);
		SumTask task2 = new SumTask(51,100);
		
		Thread thread1 = new Thread(task1, "thread-1");
		Thread thread2 = new Thread(task2, "thread-2");
		
		thread1.start();
		thread2.start();
		
		// 스레드가 종료될때 까지 대기
		log("join() - main 스레드가 thread1, thread2 종료까지 대기");
		thread1.join();
		thread2.join();
		log("main  스레드 대기 완료");
		
		
		log("task1.result = "+task1.result);
		log("task2.result = "+task2.result);
		
		int sumAll = task1.result + task2.result;
		log("task1 + task2 = "+sumAll);
		
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
