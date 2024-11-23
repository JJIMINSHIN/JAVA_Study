package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV1(2);
		
		//2.생산자, 소비자 실행 순서 선택, 반드시 하나만 선택!
		// 생산자
		//producerFrist(queue);
		
		// 소비자
		consumerFrist(queue);
		
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
 * 생성자 실행
16:11:02.821 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV1 == 

16:11:02.827 [     main] 생산자 시작 
16:11:02.840 [producer1] [생산 시도] data1 -> [] 
16:11:02.841 [producer1] [생산 완료] data1 -> [data1] 
16:11:02.937 [producer2] [생산 시도] data2 -> [data1] 
16:11:02.938 [producer2] [생산 완료] data2 -> [data1, data2] 
16:11:03.046 [producer3] [생산 시도] data3 -> [data1, data2] 
16:11:03.050 [producer3] [put] 큐가 가득참, 버림 : data3 
16:11:03.052 [producer3] [생산 완료] data3 -> [data1, data2] 

16:11:03.156 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
16:11:03.159 [     main] producer1 : TERMINATED 
16:11:03.160 [     main] producer2 : TERMINATED 
16:11:03.161 [     main] producer3 : TERMINATED 

16:11:03.162 [     main] 생산자 시작 
16:11:03.172 [consumer1] [소비 시도] ? <- [data1, data2] 
16:11:03.174 [consumer1] [소비 완료] data1 <- [data2] 
16:11:03.279 [consumer2] [소비 시도] ? <- [data2] 
16:11:03.280 [consumer2] [소비 완료] data2 <- [] 
16:11:03.388 [consumer3] [소비 시도] ? <- [] 
16:11:03.389 [consumer3] [소비 완료] null <- [] 

16:11:03.495 [     main] 현재 상태 출력, 큐 데이터 [] 
16:11:03.496 [     main] producer1 : TERMINATED 
16:11:03.498 [     main] producer2 : TERMINATED 
16:11:03.499 [     main] producer3 : TERMINATED 
16:11:03.500 [     main] consumer1 : TERMINATED 
16:11:03.501 [     main] consumer2 : TERMINATED 
16:11:03.502 [     main] consumer3 : TERMINATED 
16:11:03.504 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV1 == 


 * 
 * 소비자 먼저 실행
16:11:27.013 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV1 == 

16:11:27.018 [     main] 생산자 시작 
16:11:27.027 [consumer1] [소비 시도] ? <- [] 
16:11:27.033 [consumer1] [소비 완료] null <- [] 
16:11:27.143 [consumer2] [소비 시도] ? <- [] 
16:11:27.144 [consumer2] [소비 완료] null <- [] 
16:11:27.252 [consumer3] [소비 시도] ? <- [] 
16:11:27.253 [consumer3] [소비 완료] null <- [] 

16:11:27.360 [     main] 현재 상태 출력, 큐 데이터 [] 
16:11:27.362 [     main] consumer1 : TERMINATED 
16:11:27.362 [     main] consumer2 : TERMINATED 
16:11:27.363 [     main] consumer3 : TERMINATED 

16:11:27.364 [     main] 생산자 시작 
16:11:27.369 [producer1] [생산 시도] data1 -> [] 
16:11:27.370 [producer1] [생산 완료] data1 -> [data1] 
16:11:27.470 [producer2] [생산 시도] data2 -> [data1] 
16:11:27.471 [producer2] [생산 완료] data2 -> [data1, data2] 
16:11:27.578 [producer3] [생산 시도] data3 -> [data1, data2] 
16:11:27.580 [producer3] [put] 큐가 가득참, 버림 : data3 
16:11:27.580 [producer3] [생산 완료] data3 -> [data1, data2] 

16:11:27.687 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
16:11:27.689 [     main] consumer1 : TERMINATED 
16:11:27.690 [     main] consumer2 : TERMINATED 
16:11:27.691 [     main] consumer3 : TERMINATED 
16:11:27.692 [     main] producer1 : TERMINATED 
16:11:27.693 [     main] producer2 : TERMINATED 
16:11:27.694 [     main] producer3 : TERMINATED 
16:11:27.696 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV1 == 


 *
 * */
