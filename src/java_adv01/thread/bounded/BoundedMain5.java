package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMain5 {
	
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
00:07:52.131 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV4 == 

00:07:52.138 [     main] 생산자 시작 
00:07:52.158 [producer1] [생산 시도] data1 -> [] 
00:07:52.158 [producer1] [put] 생산자 데이터 저장, signal() 호출 
00:07:52.159 [producer1] [생산 완료] data1 -> [data1] 
00:07:52.260 [producer2] [생산 시도] data2 -> [data1] 
00:07:52.260 [producer2] [put] 생산자 데이터 저장, signal() 호출 
00:07:52.260 [producer2] [생산 완료] data2 -> [data1, data2] 
00:07:52.370 [producer3] [생산 시도] data3 -> [data1, data2] 
00:07:52.371 [producer3] [put] 큐가 가득 참, 생산자 대기 

00:07:52.482 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
00:07:52.484 [     main] producer1 : TERMINATED 
00:07:52.485 [     main] producer2 : TERMINATED 
00:07:52.485 [     main] producer3 : WAITING 

00:07:52.486 [     main] 생산자 시작 
00:07:52.494 [consumer1] [소비 시도] ? <- [data1, data2] 
00:07:52.495 [consumer1] [take] 소비자 데이터 획득, signal() 호출 
00:07:52.496 [producer3] [put] 생산자 깨어남 
00:07:52.497 [consumer1] [소비 완료] data1 <- [data2] 
00:07:52.497 [producer3] [put] 생산자 데이터 저장, signal() 호출 
00:07:52.500 [producer3] [생산 완료] data3 -> [data2, data3] 
00:07:52.605 [consumer2] [소비 시도] ? <- [data2, data3] 
00:07:52.606 [consumer2] [take] 소비자 데이터 획득, signal() 호출 
00:07:52.607 [consumer2] [소비 완료] data2 <- [data3] 
00:07:52.711 [consumer3] [소비 시도] ? <- [data3] 
00:07:52.712 [consumer3] [take] 소비자 데이터 획득, signal() 호출 
00:07:52.712 [consumer3] [소비 완료] data3 <- [] 

00:07:52.821 [     main] 현재 상태 출력, 큐 데이터 [] 
00:07:52.822 [     main] producer1 : TERMINATED 
00:07:52.823 [     main] producer2 : TERMINATED 
00:07:52.823 [     main] producer3 : TERMINATED 
00:07:52.824 [     main] consumer1 : TERMINATED 
00:07:52.824 [     main] consumer2 : TERMINATED 
00:07:52.826 [     main] consumer3 : TERMINATED 
00:07:52.828 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV4 == 



 * 
 * 소비자 실행 결과
00:08:35.074 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV4 == 

00:08:35.081 [     main] 생산자 시작 
00:08:35.091 [consumer1] [소비 시도] ? <- [] 
00:08:35.092 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
00:08:35.203 [consumer2] [소비 시도] ? <- [] 
00:08:35.203 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
00:08:35.313 [consumer3] [소비 시도] ? <- [] 
00:08:35.313 [consumer3] [take] 큐에 데이터가 없음, 소비자 대기 

00:08:35.422 [     main] 현재 상태 출력, 큐 데이터 [] 
00:08:35.433 [     main] consumer1 : WAITING 
00:08:35.434 [     main] consumer2 : WAITING 
00:08:35.434 [     main] consumer3 : WAITING 

00:08:35.435 [     main] 생산자 시작 
00:08:35.439 [producer1] [생산 시도] data1 -> [] 
00:08:35.439 [producer1] [put] 생산자 데이터 저장, signal() 호출 
00:08:35.440 [consumer1] [take] 소비자 깨어남 
00:08:35.440 [consumer1] [take] 소비자 데이터 획득, signal() 호출 
00:08:35.440 [producer1] [생산 완료] data1 -> [data1] 
00:08:35.441 [consumer2] [take] 소비자 깨어남 
00:08:35.441 [consumer1] [소비 완료] data1 <- [] 
00:08:35.443 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
00:08:35.548 [producer2] [생산 시도] data2 -> [] 
00:08:35.548 [producer2] [put] 생산자 데이터 저장, signal() 호출 
00:08:35.549 [producer2] [생산 완료] data2 -> [data2] 
00:08:35.549 [consumer3] [take] 소비자 깨어남 
00:08:35.549 [consumer3] [take] 소비자 데이터 획득, signal() 호출 
00:08:35.550 [consumer2] [take] 소비자 깨어남 
00:08:35.550 [consumer3] [소비 완료] data2 <- [] 
00:08:35.550 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
00:08:35.655 [producer3] [생산 시도] data3 -> [] 
00:08:35.655 [producer3] [put] 생산자 데이터 저장, signal() 호출 
00:08:35.656 [producer3] [생산 완료] data3 -> [data3] 
00:08:35.656 [consumer2] [take] 소비자 깨어남 
00:08:35.656 [consumer2] [take] 소비자 데이터 획득, signal() 호출 
00:08:35.656 [consumer2] [소비 완료] data3 <- [] 

00:08:35.764 [     main] 현재 상태 출력, 큐 데이터 [] 
00:08:35.766 [     main] consumer1 : TERMINATED 
00:08:35.768 [     main] consumer2 : TERMINATED 
00:08:35.769 [     main] consumer3 : TERMINATED 
00:08:35.771 [     main] producer1 : TERMINATED 
00:08:35.772 [     main] producer2 : TERMINATED 
00:08:35.773 [     main] producer3 : TERMINATED 
00:08:35.775 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV4 == 

 * 
 * */