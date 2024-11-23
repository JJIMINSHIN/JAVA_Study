package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMain2 {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV2(2);
		
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
 * 생산자 실행 결과
16:49:34.182 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV2 == 

16:49:34.196 [     main] 생산자 시작 
16:49:34.235 [producer1] [생산 시도] data1 -> [] 
16:49:34.236 [producer1] [생산 완료] data1 -> [data1] 
16:49:34.335 [producer2] [생산 시도] data2 -> [data1] 
16:49:34.336 [producer2] [생산 완료] data2 -> [data1, data2] 
16:49:34.444 [producer3] [생산 시도] data3 -> [data1, data2] 
16:49:34.447 [producer3] [put] 큐가 가득참, 생산자 대기  

16:49:34.554 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
16:49:34.557 [     main] producer1 : TERMINATED 
16:49:34.558 [     main] producer2 : TERMINATED 
16:49:34.560 [     main] producer3 : TIMED_WAITING 

16:49:34.564 [     main] 생산자 시작 
16:49:34.587 [consumer1] [소비 시도] ? <- [data1, data2] 
16:49:34.691 [consumer2] [소비 시도] ? <- [data1, data2] 
16:49:34.793 [consumer3] [소비 시도] ? <- [data1, data2] 

16:49:34.894 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
16:49:34.896 [     main] producer1 : TERMINATED 
16:49:34.897 [     main] producer2 : TERMINATED 
16:49:34.898 [     main] producer3 : TIMED_WAITING 
16:49:34.899 [     main] consumer1 : BLOCKED 
16:49:34.901 [     main] consumer2 : BLOCKED 
16:49:34.901 [     main] consumer3 : BLOCKED 
16:49:34.904 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV2 == 
16:49:35.459 [producer3] [put] 큐가 가득참, 생산자 대기  
16:49:36.473 [producer3] [put] 큐가 가득참, 생산자 대기  
16:49:37.486 [producer3] [put] 큐가 가득참, 생산자 대기  
16:49:38.499 [producer3] [put] 큐가 가득참, 생산자 대기
 * 
 * 소비자 실행 결과
16:50:55.205 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV2 == 

16:50:55.214 [     main] 생산자 시작 
16:50:55.228 [consumer1] [소비 시도] ? <- [] 
16:50:55.228 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
16:50:55.338 [consumer2] [소비 시도] ? <- [] 
16:50:55.444 [consumer3] [소비 시도] ? <- [] 

16:50:55.545 [     main] 현재 상태 출력, 큐 데이터 [] 
16:50:55.564 [     main] consumer1 : TIMED_WAITING 
16:50:55.565 [     main] consumer2 : BLOCKED 
16:50:55.567 [     main] consumer3 : BLOCKED 

16:50:55.569 [     main] 생산자 시작 
16:50:55.577 [producer1] [생산 시도] data1 -> [] 
16:50:55.674 [producer2] [생산 시도] data2 -> [] 
16:50:55.775 [producer3] [생산 시도] data3 -> [] 

16:50:55.876 [     main] 현재 상태 출력, 큐 데이터 [] 
16:50:55.877 [     main] consumer1 : TIMED_WAITING 
16:50:55.877 [     main] consumer2 : BLOCKED 
16:50:55.877 [     main] consumer3 : BLOCKED 
16:50:55.880 [     main] producer1 : BLOCKED 
16:50:55.880 [     main] producer2 : BLOCKED 
16:50:55.880 [     main] producer3 : BLOCKED 
16:50:55.881 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV2 == 
16:50:56.249 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
16:50:57.259 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
 * 
 * */