package java_adv01.thread.control.join;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 순서
23:01:54.305 [     main] Start 
23:01:54.315 [ thread-1] 작업 시작 
23:01:54.315 [     main] End 
23:01:54.315 [ thread-2] 작업 시작 
23:01:56.323 [ thread-2] 작업 완료 
23:01:56.323 [ thread-1] 작업 완료 
 * */
public class JoinMainV0 {
	
	public static void main(String args[]) {
		log("Start");
		
		Thread thread1 = new Thread(new Job(), "thread-1");
		Thread thread2 = new Thread(new Job(), "thread-2");
		
		thread1.start();
		thread2.start();
		
		log("End");
	}
	
	static class Job implements Runnable{
		
		@Override
		public void run() {
			log("작업 시작");
			sleep(2000);
			log("작업 완료");
			
		}
	}

}
