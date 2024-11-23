package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMain6_2 {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV6_2(2);
		
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
01:47:34.562 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV6_2 == 

01:47:34.569 [     main] 생산자 시작 
01:47:34.587 [producer1] [생산 시도] data1 -> [] 
01:47:34.587 [producer1] 저장 시도 결과 = true 
01:47:34.588 [producer1] [생산 완료] data1 -> [data1] 
01:47:34.695 [producer2] [생산 시도] data2 -> [data1] 
01:47:34.696 [producer2] 저장 시도 결과 = true 
01:47:34.696 [producer2] [생산 완료] data2 -> [data1, data2] 
01:47:34.803 [producer3] [생산 시도] data3 -> [data1, data2] 
01:47:34.803 [producer3] 저장 시도 결과 = false 
01:47:34.804 [producer3] [생산 완료] data3 -> [data1, data2] 

01:47:34.914 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
01:47:34.916 [     main] producer1 : TERMINATED 
01:47:34.917 [     main] producer2 : TERMINATED 
01:47:34.918 [     main] producer3 : TERMINATED 

01:47:34.919 [     main] 생산자 시작 
01:47:34.927 [consumer1] [소비 시도] ? <- [data1, data2] 
01:47:34.929 [consumer1] [소비 완료] data1 <- [data2] 
01:47:35.036 [consumer2] [소비 시도] ? <- [data2] 
01:47:35.037 [consumer2] [소비 완료] data2 <- [] 
01:47:35.143 [consumer3] [소비 시도] ? <- [] 
01:47:35.144 [consumer3] [소비 완료] null <- [] 

01:47:35.251 [     main] 현재 상태 출력, 큐 데이터 [] 
01:47:35.252 [     main] producer1 : TERMINATED 
01:47:35.253 [     main] producer2 : TERMINATED 
01:47:35.254 [     main] producer3 : TERMINATED 
01:47:35.255 [     main] consumer1 : TERMINATED 
01:47:35.256 [     main] consumer2 : TERMINATED 
01:47:35.258 [     main] consumer3 : TERMINATED 
01:47:35.259 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV6_2 == 

 * */