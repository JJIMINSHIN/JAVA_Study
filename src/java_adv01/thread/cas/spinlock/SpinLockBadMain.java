package java_adv01.thread.cas.spinlock;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

/* 
 * 실행 결과
01:23:03.337 [ Thread-1] 락 획득 시도 
01:23:03.337 [ Thread-2] 락 획득 시도 
01:23:03.455 [ Thread-1] 락 획득 완료 
01:23:03.455 [ Thread-2] 락 획득 완료 
01:23:03.455 [ Thread-1] 비즈니스 로직 실행 
01:23:03.457 [ Thread-2] 비즈니스 로직 실행 
01:23:03.460 [ Thread-1] 락 반납 완료 
01:23:03.461 [ Thread-2] 락 반납 완료 

 * */
public class SpinLockBadMain {

	public static void main(String args[]) {
		SpinLockBad spinLock = new SpinLockBad();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				spinLock.lock();
				try {
					// critical section
					log("비즈니스 로직 실행");
					sleep(1); // 오래 걸리는 로직에서 스핀 락 사용X
				} finally {
					spinLock.unlock();
				}
			}
		};
		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		t1.start();
		t2.start();
	}

}
