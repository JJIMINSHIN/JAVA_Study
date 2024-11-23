package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMain4 {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV4(2);
		
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
23:54:52.467 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV4 == 

23:54:52.475 [     main] 생산자 시작 
23:54:52.494 [producer1] [생산 시도] data1 -> [] 
23:54:52.495 [producer1] [put] 생성자 데이터 저장, signal() 호출  
23:54:52.496 [producer1] [생산 완료] data1 -> [data1] 
23:54:52.589 [producer2] [생산 시도] data2 -> [data1] 
23:54:52.590 [producer2] [put] 생성자 데이터 저장, signal() 호출  
23:54:52.590 [producer2] [생산 완료] data2 -> [data1, data2] 
23:54:52.698 [producer3] [생산 시도] data3 -> [data1, data2] 
23:54:52.698 [producer3] [put] 큐가 가득참, 생산자 대기  

23:54:52.807 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
23:54:52.808 [     main] producer1 : TERMINATED 
23:54:52.808 [     main] producer2 : TERMINATED 
23:54:52.810 [     main] producer3 : WAITING 

23:54:52.810 [     main] 생산자 시작 
23:54:52.814 [consumer1] [소비 시도] ? <- [data1, data2] 
23:54:52.815 [consumer1] [take] 소비자 데이터 획득, notify() 호출 
23:54:52.815 [producer3] [put] 생성자 깨어남  
23:54:52.815 [consumer1] [소비 완료] data1 <- [data2] 
23:54:52.816 [producer3] [put] 생성자 데이터 저장, signal() 호출  
23:54:52.817 [producer3] [생산 완료] data3 -> [data2, data3] 
23:54:52.917 [consumer2] [소비 시도] ? <- [data2, data3] 
23:54:52.918 [consumer2] [take] 소비자 데이터 획득, notify() 호출 
23:54:52.919 [consumer2] [소비 완료] data2 <- [data3] 
23:54:53.026 [consumer3] [소비 시도] ? <- [data3] 
23:54:53.027 [consumer3] [take] 소비자 데이터 획득, notify() 호출 
23:54:53.027 [consumer3] [소비 완료] data3 <- [] 

23:54:53.134 [     main] 현재 상태 출력, 큐 데이터 [] 
23:54:53.136 [     main] producer1 : TERMINATED 
23:54:53.137 [     main] producer2 : TERMINATED 
23:54:53.138 [     main] producer3 : TERMINATED 
23:54:53.139 [     main] consumer1 : TERMINATED 
23:54:53.142 [     main] consumer2 : TERMINATED 
23:54:53.143 [     main] consumer3 : TERMINATED 
23:54:53.145 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV4 == 


 * 
 * 소비자 실행 결과
00:00:08.089 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV4 == 

00:00:08.109 [     main] 생산자 시작 
00:00:08.131 [consumer1] [소비 시도] ? <- [] 
00:00:08.132 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
00:00:08.235 [consumer2] [소비 시도] ? <- [] 
00:00:08.237 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
00:00:08.345 [consumer3] [소비 시도] ? <- [] 
00:00:08.345 [consumer3] [take] 큐에 데이터가 없음, 소비자 대기 

00:00:08.452 [     main] 현재 상태 출력, 큐 데이터 [] 
00:00:08.479 [     main] consumer1 : WAITING 
00:00:08.480 [     main] consumer2 : WAITING 
00:00:08.493 [     main] consumer3 : WAITING 

00:00:08.495 [     main] 생산자 시작 
00:00:08.517 [producer1] [생산 시도] data1 -> [] 
00:00:08.519 [producer1] [put] 생산자 데이터 저장, signal() 호출 
00:00:08.521 [producer1] [생산 완료] data1 -> [data1] 
00:00:08.524 [consumer1] [take] 소비자 깨어남 
00:00:08.528 [consumer1] [take] 소비자 데이터 획득, signal() 호출 
00:00:08.530 [consumer2] [take] 소비자 깨어남 
00:00:08.530 [consumer1] [소비 완료] data1 <- [] 
00:00:08.531 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
00:00:08.627 [producer2] [생산 시도] data2 -> [] 
00:00:08.627 [producer2] [put] 생산자 데이터 저장, signal() 호출 
00:00:08.628 [producer2] [생산 완료] data2 -> [data2] 
00:00:08.628 [consumer3] [take] 소비자 깨어남 
00:00:08.630 [consumer3] [take] 소비자 데이터 획득, signal() 호출 
00:00:08.631 [consumer3] [소비 완료] data2 <- [] 
00:00:08.631 [consumer2] [take] 소비자 깨어남 
00:00:08.632 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
00:00:08.734 [producer3] [생산 시도] data3 -> [] 
00:00:08.734 [producer3] [put] 생산자 데이터 저장, signal() 호출 
00:00:08.735 [producer3] [생산 완료] data3 -> [data3] 
00:00:08.735 [consumer2] [take] 소비자 깨어남 
00:00:08.737 [consumer2] [take] 소비자 데이터 획득, signal() 호출 
00:00:08.737 [consumer2] [소비 완료] data3 <- [] 

00:00:08.843 [     main] 현재 상태 출력, 큐 데이터 [] 
00:00:08.843 [     main] consumer1 : TERMINATED 
00:00:08.845 [     main] consumer2 : TERMINATED 
00:00:08.846 [     main] consumer3 : TERMINATED 
00:00:08.846 [     main] producer1 : TERMINATED 
00:00:08.847 [     main] producer2 : TERMINATED 
00:00:08.849 [     main] producer3 : TERMINATED 
00:00:08.850 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV4 == 
 * 
 * */