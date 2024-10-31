package java_adv01.thread.volatile1.copy;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;


public class VolatileFlagMain {
	
	public static void main(String args[]) {
		MyTask task  = new MyTask();
		Thread t = new Thread(task, "work");
		
		log("runFlag = "+task.runFlag);
		t.start();
		
		sleep(1000);
		log("runFlag를 false로 변경 시도");
		task.runFlag= false;
		log("runFlag = "+task.runFlag); 
		log("main 종료");
		
	}
	
	static class MyTask implements Runnable{
		
		//boolean runFlag = true;
		volatile boolean runFlag=true;
		 
		@Override
		public void run() {
			log("task 시작");
			while(runFlag) {
				
			}
			log("task 종료");

		}
	}

}
