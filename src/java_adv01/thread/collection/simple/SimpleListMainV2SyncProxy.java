package java_adv01.thread.collection.simple;

import static java_adv01.util.MyLogger.log;

import java_adv01.thread.collection.simple.list.*;

/*
 * 실행 결과
15:57:07.719 [     main] SyncProxyList 
15:57:07.830 [ Thread-1] Thread-1:list.add(A) 
15:57:07.935 [ Thread-2] Thread-2:list.add(B) 
15:57:07.935 [     main] [A, B] size = 2, capacity = 5 by SyncProxyList 
 * */
public class SimpleListMainV2SyncProxy {

	public static void main(String args[]) throws InterruptedException {
		test(new SyncProxyList(new BasicList()));

	}

	private static void test(SimpleList list) throws InterruptedException {

		log(list.getClass().getSimpleName());

		// A를 리스트에 저장하는 코드
		Runnable addA = new Runnable() {

			@Override
			public void run() {
				list.add("A");
				log("Thread-1:list.add(A)");
			}
		};

		// B를 리스트에 저장하는 코드
		Runnable addB = new Runnable() {

			@Override
			public void run() {
				list.add("B");
				log("Thread-2:list.add(B)");
			}
		};

		Thread thread1 = new Thread(addA, "Thread-1");
		Thread thread2 = new Thread(addB, "Thread-2");
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		log(list);

	}

}
