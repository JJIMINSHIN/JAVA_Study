package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.*;

public class BoundedQueueV6_1 implements BoundedQueue {

	private BlockingQueue<String> queue;

	public BoundedQueueV6_1(int max) {
		queue = new ArrayBlockingQueue<String>(max);
	}

	public void put(String data) {
		try {
			queue.put(data);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String take() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return queue.toString();
	}

}
