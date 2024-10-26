package java_adv01.thread.control.interrupt;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
16:21:23.311 [     work] 작업 중 
16:21:26.321 [     work] 작업 중 
16:21:27.239 [     main] 작업 중단 지시 thread.interrupt() 
16:21:27.255 [     main] work 스레드 인터럽트 상태1 = true  => work스레드는 인터럽트 상태
16:21:27.255 [     work] work 스레드 인터럽트 상태2 = false => sleep에서 예외 발생, runnable 상태
16:21:27.257 [     work] interrupt message = sleep interrupted 
16:21:27.257 [     work] state = RUNNABLE 
16:21:27.257 [     work] 자원 정리 
16:21:27.257 [     work] 작업 종료 

 * */
public class ThreadStopMainV2 {

	public static void main(String args[]) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(4000);
		log("작업 중단 지시 thread.interrupt()");
		thread.interrupt(); //인터럽트 주기
		log("work 스레드 인터럽트 상태1 = "+thread.isInterrupted());

	}

	static class MyTask implements Runnable {

		volatile boolean runFlag = true;

		@Override
		public void run() {
			try {
				while (true) {
					log("작업 중");
					Thread.sleep(3000);
				}
			} catch (InterruptedException e) {
				log("work 스레드 인터럽트 상태2 = "+Thread.currentThread().isInterrupted());
				log("interrupt message = "+e.getMessage());
				log("state = "+Thread.currentThread().getState());
			}

			log("자원 정리");
			log("작업 종료");
		}

	}
}
