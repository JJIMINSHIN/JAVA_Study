package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;

/*
 * 데이터를 생성하는 생성자 스레드가 실행하는 클래스
 * 스레드 실행시, put()을 호출해 데이터(request)를 큐에 보관
 * */
public class ProducerTask implements Runnable {
	
	private BoundedQueue queue;
	private String request;

	public ProducerTask(BoundedQueue queue, String request) {
		this.queue = queue;
		this.request = request;
	}

	@Override
	public void run() {
		log("[생산 시도] "+request+" -> "+queue);
		queue.put(request);
		log("[생산 완료] "+request+" -> "+queue);
	}
}
