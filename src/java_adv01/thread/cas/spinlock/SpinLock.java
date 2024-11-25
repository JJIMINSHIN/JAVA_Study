package java_adv01.thread.cas.spinlock;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
	
	private final AtomicBoolean lock  = new AtomicBoolean(false);
	
	public void lock() {
		log("락 획득 시도");
		while(!lock.compareAndSet(false, true)) { // true면 !때문에 false로 바뀌니깐
			// 락을 획득할 때까지 스핀 대기(바쁜 대기)한다.
			log("락 획득 실패 - 스핀 대기");
		}
		log("락 획득 완료");
	}
	public void unlock() {
		lock.set(false);
		log("락 반납 완료");
	}

}
