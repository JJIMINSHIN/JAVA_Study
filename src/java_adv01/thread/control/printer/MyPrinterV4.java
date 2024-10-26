package java_adv01.thread.control.printer;

import static java_adv01.util.MyLogger.log;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;


/* 
 * yield 메소드 추가\
 * thread가 많이 실행되고 있다면 양보할 수 있또록 설정
 * CPU 사용률을 줄이기 위해 sleep(1)와 같은 부분도 넣어도 된다 
 * */
public class MyPrinterV4 {
	
	public static void main(String args[]) {
		Printer printer  = new Printer();
		Thread printerThread = new Thread(printer, "printer");
		printerThread.start();
		
		//입력
		Scanner userInput = new Scanner(System.in);
		while(true) {
			log("프린터할 문서를 입력하세요 :  종료(q) : ");
			String input = userInput.nextLine();
			if(input.equals("q")) {
				printerThread.interrupt(); // 인터럽트 걸기
				break;
			}
			
			printer.addJob(input);
			
		}
		
	}
	
	static class Printer implements Runnable{
		
		Queue<String> jobQueue  = new ConcurrentLinkedQueue<>();
		
		
		@Override
		public void run() {
			while(!Thread.interrupted()) {
				if(jobQueue.isEmpty()) {
					Thread.yield(); // 
					continue;
				}
				
				try {
					String job = jobQueue.poll();
					log("출력 시작 : "+job +" , 대기 문서 : "+jobQueue);
					Thread.sleep(3000);
					log("출력 완료");
				} catch (InterruptedException e) {
					log("인터럽트!");
					break;
				}
			}
			
			log("프린터 종료");
		}
		
		public void addJob(String input) {
			jobQueue.offer(input);
		}
	}
}
