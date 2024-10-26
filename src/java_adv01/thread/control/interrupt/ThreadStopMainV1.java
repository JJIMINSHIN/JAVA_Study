package java_adv01.thread.control.interrupt;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
16:12:15.548 [     work] 작업 중 
16:12:18.562 [     work] 작업 중 
16:12:19.479 [     main] 작업 중단 지시 runFlag=false 
16:12:21.569 [     work] 자원 정리 
16:12:21.570 [     work] 작업 종료 
 * 
 * */
public class ThreadStopMainV1 {

	public static void main(String args[]) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();
		
		sleep(4000);
		log("작업 중단 지시 runFlag=false");
		task.runFlag =false;
	}
	
	
	static class MyTask implements Runnable{
	
		volatile boolean runFlag = true;
		
		@Override
		public void run() {
			while(runFlag) {
				log("작업 중");
				sleep(3000);
			}
			
			log("자원 정리");
			log("작업 종료");
		}
		
		
	}
}
