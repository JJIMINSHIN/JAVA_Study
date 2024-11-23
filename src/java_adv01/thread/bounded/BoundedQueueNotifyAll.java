package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueNotifyAll implements BoundedQueue{
	 
	private final Queue<String> queue = new ArrayDeque<String>();
	private final int max;

	public BoundedQueueNotifyAll(int max) {
		this.max = max;
	}
	
	@Override
	public synchronized void put(String data) {
		while(queue.size()==max) {
			log("[put] 큐가 가득참, 생산자 대기 ");

			try {
				wait(); //Runnable -> WAITING, 락 반납
				log("[put] 생성자 깨어남 ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		queue.offer(data);
		log("[put] 생성자 데이터 저장, notify() 호출 ");
		notifyAll(); // 대기 스레디, wait ->blocked
	}
	
	@Override
	public synchronized String take() {
		while(queue.isEmpty()) {
			log("[take] 큐에 데이터가 없음, 소비자 대기");
			try {
				wait();
				log("[take] 소비자 깨어남");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String data = queue.poll();
		log("[take] 소비자 데이터 획득, notify() 호출");
		notifyAll();
		return data;
	}
	
	@Override
	public String toString() {
		return queue.toString();
	}
	
}
