package java_adv01.thread.control.test;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 내 문제 풀이
 * 모든 조인 메서드에 1초 순위 매김
23:47:20.018 [       t1] 1 
23:47:20.893 [       t2] 1 
23:47:21.034 [       t1] 2 
23:47:21.898 [       t2] 2 
23:47:21.898 [       t3] 1 
23:47:22.038 [       t1] 3 
23:47:22.900 [     main] 모든 스레드 실행 완료 
23:47:22.914 [       t3] 2 
23:47:22.914 [       t2] 3 
23:47:23.918 [       t3] 3 

 * 강의 코드 => 조인을 한번에 하기
 * 실행 결과
23:48:55.396 [       t1] 1 
23:48:55.396 [       t3] 1 
23:48:55.396 [       t2] 1 
23:48:56.411 [       t2] 2 
23:48:56.411 [       t3] 2 
23:48:56.411 [       t1] 2 
23:48:57.421 [       t1] 3 
23:48:57.421 [       t2] 3 
23:48:57.421 [       t3] 3 
23:48:58.439 [     main] 모든 스레드 실행 완료 


 * */
public class JoinTestMain2 {
	
	public static void main(String args[]) throws InterruptedException {
		
		Thread t1 = new Thread(new MyTask(), "t1");
		Thread t2 = new Thread(new MyTask(), "t2");
		Thread t3 = new Thread(new MyTask(), "t3");
		
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
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
