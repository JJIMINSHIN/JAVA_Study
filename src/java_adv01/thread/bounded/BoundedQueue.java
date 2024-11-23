package java_adv01.thread.bounded;

public interface BoundedQueue {
	void put(String data);
	
	String take();
}
