package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMain6_1 {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV6_1(2);
		
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
01:39:22.402 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV6_1 == 

01:39:22.423 [     main] 생산자 시작 
01:39:22.476 [producer1] [생산 시도] data1 -> [] 
01:39:22.478 [producer1] [생산 완료] data1 -> [data1] 
01:39:22.558 [producer2] [생산 시도] data2 -> [data1] 
01:39:22.559 [producer2] [생산 완료] data2 -> [data1, data2] 
01:39:22.668 [producer3] [생산 시도] data3 -> [data1, data2] 

01:39:22.778 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
01:39:22.780 [     main] producer1 : TERMINATED 
01:39:22.781 [     main] producer2 : TERMINATED 
01:39:22.782 [     main] producer3 : WAITING 

01:39:22.784 [     main] 생산자 시작 
01:39:22.793 [consumer1] [소비 시도] ? <- [data1, data2] 
01:39:22.794 [producer3] [생산 완료] data3 -> [data2, data3] 
01:39:22.794 [consumer1] [소비 완료] data1 <- [data2] 
01:39:22.902 [consumer2] [소비 시도] ? <- [data2, data3] 
01:39:22.902 [consumer2] [소비 완료] data2 <- [data3] 
01:39:23.009 [consumer3] [소비 시도] ? <- [data3] 
01:39:23.010 [consumer3] [소비 완료] data3 <- [] 

01:39:23.118 [     main] 현재 상태 출력, 큐 데이터 [] 
01:39:23.120 [     main] producer1 : TERMINATED 
01:39:23.120 [     main] producer2 : TERMINATED 
01:39:23.121 [     main] producer3 : TERMINATED 
01:39:23.123 [     main] consumer1 : TERMINATED 
01:39:23.124 [     main] consumer2 : TERMINATED 
01:39:23.125 [     main] consumer3 : TERMINATED 
01:39:23.127 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV6_1 == 

 * 
 * 소비자 실행 결과
01:38:47.976 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV6_1 == 

01:38:47.996 [     main] 생산자 시작 
01:38:48.020 [consumer1] [소비 시도] ? <- [] 
01:38:48.124 [consumer2] [소비 시도] ? <- [] 
01:38:48.235 [consumer3] [소비 시도] ? <- [] 

01:38:48.341 [     main] 현재 상태 출력, 큐 데이터 [] 
01:38:48.367 [     main] consumer1 : WAITING 
01:38:48.368 [     main] consumer2 : WAITING 
01:38:48.369 [     main] consumer3 : WAITING 

01:38:48.370 [     main] 생산자 시작 
01:38:48.383 [producer1] [생산 시도] data1 -> [] 
01:38:48.385 [consumer1] [소비 완료] data1 <- [] 
01:38:48.385 [producer1] [생산 완료] data1 -> [data1] 
01:38:48.486 [producer2] [생산 시도] data2 -> [] 
01:38:48.487 [producer2] [생산 완료] data2 -> [data2] 
01:38:48.487 [consumer2] [소비 완료] data2 <- [] 
01:38:48.594 [producer3] [생산 시도] data3 -> [] 
01:38:48.595 [producer3] [생산 완료] data3 -> [data3] 
01:38:48.595 [consumer3] [소비 완료] data3 <- [] 

01:38:48.705 [     main] 현재 상태 출력, 큐 데이터 [] 
01:38:48.706 [     main] consumer1 : TERMINATED 
01:38:48.707 [     main] consumer2 : TERMINATED 
01:38:48.708 [     main] consumer3 : TERMINATED 
01:38:48.709 [     main] producer1 : TERMINATED 
01:38:48.710 [     main] producer2 : TERMINATED 
01:38:48.711 [     main] producer3 : TERMINATED 
01:38:48.713 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV6_1 == 


 * 
 * */