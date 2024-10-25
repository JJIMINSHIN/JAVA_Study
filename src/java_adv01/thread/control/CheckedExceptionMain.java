package java_adv01.thread.control;

import static java_adv01.util.ThreadUtils.*;

public class CheckedExceptionMain {
	
	public static void main(String args[]) throws Exception {
		throw new Exception();
	}
	
	static class CheckedRunnable implements Runnable{
		/*
		 * Runnable에서 예외처리를 안하기 때문에 run()에서는 예외처리를 잡을 수 없다.
		 * */
		@Override
		public void run() /*throws Exception */{
			//throw new Exception();
			sleep(1000);
		}
	}

}
