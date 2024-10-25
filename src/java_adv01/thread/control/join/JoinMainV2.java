package java_adv01.thread.control.join;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 순서
23:19:49.468 [     main] Start 
23:19:49.477 [     main] main 스레드 sleep() 
23:19:49.477 [ thread-1] 작업 시작 
23:19:49.477 [ thread-2] 작업 시작 
23:19:51.512 [ thread-2] 작업 완료 result = 3775 
23:19:51.512 [ thread-1] 작업 완료 result = 1275 
23:19:52.483 [     main] main 스레드 깨어남! 
23:19:52.485 [     main] task1.result = 1275 
23:19:52.486 [     main] task2.result = 3775 
23:19:52.488 [     main] task1 + task2 = 5050 
23:19:52.489 [     main] End 
 * 
 * */
public class JoinMainV2 {
	
	public static void main(String args[]) {
		log("Start");
		
		SumTask task1 = new SumTask(1,50);
		SumTask task2 = new SumTask(51,100);
		
		Thread thread1 = new Thread(task1, "thread-1");
		Thread thread2 = new Thread(task2, "thread-2");
		
		thread1.start();
		thread2.start();
		
		// main 스레드 계산이 끝날때까지 기다리게 하기
		log("main 스레드 sleep()");
		sleep(3000);
		log("main 스레드 깨어남!");
		
		
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
