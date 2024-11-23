package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.*;

// Special Value - 대기시 즉시 반환
public class BoundedQueueV6_2 implements BoundedQueue {

	private BlockingQueue<String> queue;

	public BoundedQueueV6_2(int max) {
		queue = new ArrayBlockingQueue<String>(max);
	}

	public void put(String data) {
		boolean result = queue.offer(data);
		log("저장 시도 결과 = " + result);
	}

	public String take() {
		return queue.poll();
	}

	@Override
	public String toString() {
		return queue.toString();
	}

}
