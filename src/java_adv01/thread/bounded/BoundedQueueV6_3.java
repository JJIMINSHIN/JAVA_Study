package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

// Time out 시간 대기 
public class BoundedQueueV6_3 implements BoundedQueue {

	private BlockingQueue<String> queue;

	public BoundedQueueV6_3(int max) {
		queue = new ArrayBlockingQueue<String>(max);
	}

	public void put(String data) {
		boolean result;
		try {
			result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
			log("저장 시도 결과 = " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String take() {
		try {
			return queue.poll(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return queue.toString();
	}

}
