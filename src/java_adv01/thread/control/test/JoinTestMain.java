package java_adv01.thread.control.test;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 예상 결과
 * 스레드 1 => 2 => 3 => 모든 스레드 실행 완료
 * 실행 결과 (9s)
23:45:13.194 [       t1] 1 
23:45:14.229 [       t1] 2 
23:45:15.243 [       t1] 3 
23:45:16.257 [       t2] 1 
23:45:17.271 [       t2] 2 
23:45:18.285 [       t2] 3 
23:45:19.303 [       t3] 1 
23:45:20.315 [       t3] 2 
23:45:21.330 [       t3] 3 
23:45:22.331 [     main] 모든 스레드 실행 완료 

 * */
public class JoinTestMain {
	
	public static void main(String args[]) throws InterruptedException {
		
		Thread t1 = new Thread(new MyTask(), "t1");
		Thread t2 = new Thread(new MyTask(), "t2");
		Thread t3 = new Thread(new MyTask(), "t3");
		
		t1.start();
		t1.join();

		t2.start();
		t2.join();
		
		t3.start();
		t3.join();
		
		
		log("모든 스레드 실행 완료");
	}
	
	static class MyTask implements Runnable{

		@Override
		public void run() {
			for(int i=1; i<=3 ; i++) {
				log(i);
				sleep(1000);
			}
		}
	}

}
