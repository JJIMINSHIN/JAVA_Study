package java_adv01.thread.control.join;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 순서
23:14:12.921 [     main] Start 
23:14:12.930 [ thread-1] 작업 시작 
23:14:12.930 [ thread-2] 작업 시작 
23:14:12.940 [     main] task1.result = 0 
23:14:12.940 [     main] task2.result = 0 
23:14:12.940 [     main] task1 + task2 = 0 
23:14:12.941 [     main] End 
23:14:14.940 [ thread-2] 작업 완료 result = 3775 
23:14:14.940 [ thread-1] 작업 완료 result = 1275 

 => 결과가 0이 나오는 이유 : 메인스레드는 바로 값을 조회하기 때문에 thread가 끝날때까지 기다려주지 않는다!
 * 
 * */
public class JoinMainV1 {
	
	public static void main(String args[]) {
		log("Start");
		
		SumTask task1 = new SumTask(1,50);
		SumTask task2 = new SumTask(51,100);
		
		Thread thread1 = new Thread(task1, "thread-1");
		Thread thread2 = new Thread(task2, "thread-2");
		
		thread1.start();
		thread2.start();
		
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
