package java_adv01.thread.start.test;

import static java_adv01.util.MyLogger.log;

/*
 * 강의와 다르게 진행
 * 강의 :  정적 중첩 클래스 사용 
 * 내 풀이 : 익명클래스 변수 없이 직접 전달
 * static class를 만들어주었는데 나는 그냥 main에 바로 만듦
 * */
public class StartTest2Main {
	
	public static void main(String args[]) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=5; i++) {
				
					log("value : "+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}, "counter");
		thread.start();
	}
	
}
