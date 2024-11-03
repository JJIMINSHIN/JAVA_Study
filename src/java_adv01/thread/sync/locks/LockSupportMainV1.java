package java_adv01.thread.sync.locks;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.concurrent.locks.LockSupport;

/*
 * parkNanos 사용 실행결과 
17:14:28.943 [ Thread-1] park 시작 
17:14:29.152 [     main] Thread-1 state: TIMED_WAITING 
17:14:30.955 [ Thread-1] park 종료, state: RUNNABLE 
17:14:30.985 [ Thread-1] 인터럽트 상태 : false 

 * 
 * */
public class LockSupportMainV1 {
	public static void main(String args[]) {
		Thread thread1 = new Thread(new ParkTask(),"Thread-1");
		thread1.start();
		
		//잠시 대기하여 thread-1이 park 상태에 빠질 시간을 준다.
		sleep(300);
		log("Thread-1 state: "+thread1.getState());
	}
	
	static class ParkTask implements Runnable{

		@Override
		public void run() {
			log("park 시작");
			LockSupport.parkNanos(2000_000000); // 2초뒤
			log("park 종료, state: "+Thread.currentThread().getState());
			log("인터럽트 상태 : "+Thread.currentThread().isInterrupted());
			
		}
	}

}
