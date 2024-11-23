package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain6_4 {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV6_4(2);
		
		//2.생산자, 소비자 실행 순서 선택, 반드시 하나만 선택!
		// 생산자
		producerFrist(queue);
		
		// 소비자
		//consumerFrist(queue);
		
	}
	
	private static void producerFrist(BoundedQueue queue) {
		log("== [생산자 먼저 실행] 시작, "+queue.getClass().getSimpleName()+" ==");
		
		List<Thread> threads = new ArrayList<>();
		startProducer(queue, threads);
		printAllState(queue, threads);
		startConsumer(queue, threads);
		printAllState(queue, threads);
		log("== [생산자 먼저 실행] 종료, "+queue.getClass().getSimpleName()+" ==");
	}
	
	private static void consumerFrist(BoundedQueue queue) {
		log("== [소비자 먼저 실행] 시작, "+queue.getClass().getSimpleName()+" ==");
		
		List<Thread> threads = new ArrayList<>();
		startConsumer(queue, threads);
		printAllState(queue, threads);
		startProducer(queue, threads);
		printAllState(queue, threads);
		log("== [소비자 먼저 실행] 종료, "+queue.getClass().getSimpleName()+" ==");
	}
	
	private static void startProducer(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("생산자 시작");
		for(int i=1; i<=3; i++) {
			Thread producer = new Thread(new ProducerTask(queue,"data"+i),"producer"+i);
			threads.add(producer);
			producer.start();
			sleep(100);
		}
	}
	
	private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("생산자 시작");
		for(int i=1; i<=3; i++) {
			Thread consumer = new Thread(new ConsumerTask(queue,"data"+i),"consumer"+i);
			threads.add(consumer);
			consumer.start();
			sleep(100);
		}
	}
	
	public static void printAllState(BoundedQueue queue, List<Thread>threads) {
		System.out.println();
		log("현재 상태 출력, 큐 데이터 "+queue);
		for(Thread th : threads) {
			log(th.getName()+" : "+th.getState());
		}
	}

}

/*
 * 생산자 실행 결과
01:58:48.874 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV6_4 == 

01:58:48.885 [     main] 생산자 시작 
01:58:48.911 [producer1] [생산 시도] data1 -> [] 
01:58:48.912 [producer1] [생산 완료] data1 -> [data1] 
01:58:49.014 [producer2] [생산 시도] data2 -> [data1] 
01:58:49.014 [producer2] [생산 완료] data2 -> [data1, data2] 
01:58:49.122 [producer3] [생산 시도] data3 -> [data1, data2]  => IllegalStateException
Exception in thread "producer3" java.lang.IllegalStateException: Queue full
	at java.base/java.util.AbstractQueue.add(AbstractQueue.java:98)
	at java.base/java.util.concurrent.ArrayBlockingQueue.add(ArrayBlockingQueue.java:329)
	at java_adv01.thread.bounded.BoundedQueueV6_4.put(BoundedQueueV6_4.java:23)
	at java_adv01.thread.bounded.ProducerTask.run(ProducerTask.java:22)
	at java.base/java.lang.Thread.run(Thread.java:1583)

01:58:49.233 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
01:58:49.235 [     main] producer1 : TERMINATED 
01:58:49.235 [     main] producer2 : TERMINATED 
01:58:49.236 [     main] producer3 : TERMINATED 

01:58:49.237 [     main] 생산자 시작 
01:58:49.247 [consumer1] [소비 시도] ? <- [data1, data2] 
01:58:49.249 [consumer1] [소비 완료] data1 <- [data2] 
01:58:49.356 [consumer2] [소비 시도] ? <- [data2] 
01:58:49.357 [consumer2] [소비 완료] data2 <- [] 
01:58:49.465 [consumer3] [소비 시도] ? <- []  => NoSuchElementException 발생ㄴ
Exception in thread "consumer3" java.util.NoSuchElementException
	at java.base/java.util.AbstractQueue.remove(AbstractQueue.java:117)
	at java_adv01.thread.bounded.BoundedQueueV6_4.take(BoundedQueueV6_4.java:27)
	at java_adv01.thread.bounded.ConsumerTask.run(ConsumerTask.java:21)
	at java.base/java.lang.Thread.run(Thread.java:1583)

01:58:49.573 [     main] 현재 상태 출력, 큐 데이터 [] 
01:58:49.575 [     main] producer1 : TERMINATED 
01:58:49.576 [     main] producer2 : TERMINATED 
01:58:49.577 [     main] producer3 : TERMINATED 
01:58:49.579 [     main] consumer1 : TERMINATED 
01:58:49.580 [     main] consumer2 : TERMINATED 
01:58:49.581 [     main] consumer3 : TERMINATED 
01:58:49.583 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV6_4 == 



 * */