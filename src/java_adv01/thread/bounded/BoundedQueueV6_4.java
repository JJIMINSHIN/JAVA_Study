package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

// Throw Exception - 대기시 예외
public class BoundedQueueV6_4 implements BoundedQueue {

	private BlockingQueue<String> queue;

	public BoundedQueueV6_4(int max) {
		queue = new ArrayBlockingQueue<String>(max);
	}

	public void put(String data) {
		queue.add(data);
	}

	public String take() {
		return queue.remove();
	}

	@Override
	public String toString() {
		return queue.toString();
	}

}
