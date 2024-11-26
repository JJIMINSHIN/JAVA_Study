package java_mid01.lang.nested.anonymous.ex;

import java.util.Random;

public class Ex1Main {

	public static void helloDice() {
		System.out.println("프로그램 시작");
	
		System.out.println("프로그램 종료");
	}
	public static void helloSum() {
		System.out.println("프로그램 시작");
		
		// 코드 조각 종료
		
		System.out.println("프로그램 종료");
	}
	
	static class Dice implements Process{

		@Override
		public void run() {
			int randomValue = new Random().nextInt(6)+1;
			System.out.println("주사위 = "+randomValue);
		}
	}
	
	static class Sum implements Process{

		@Override
		public void run() {
			for(int i=0; i<=3; i++) {
				System.out.println("i = "+i);
			}			
		}
		
	}

	public static void main(String args[]) {
		helloDice();
		helloSum();
		
	}
	
	
}
