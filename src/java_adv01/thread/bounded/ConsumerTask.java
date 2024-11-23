package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;

/*
 * 데이터를 소비하는 소비자 스레드가 실행하는 클래스
 * 스레드 실행시 task() 호출해서 큐의 데이터를 가져와 소비
 * */
public class ConsumerTask implements Runnable {
	
	private BoundedQueue queue;
	private String request;

	public ConsumerTask(BoundedQueue queue, String request) {
		this.queue = queue;
	}

	@Override
	public void run() {
		log("[소비 시도] ? <- "+queue);
		String data = queue.take();
		log("[소비 완료] "+data+" <- "+queue);
	}
}
