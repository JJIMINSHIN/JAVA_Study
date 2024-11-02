package java_adv01.thread.sync;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * syncronized 코드 블럭 적용 => 필요한 부분에 임계영역 지정
 * 실행 결과.  => 동시성 파괴 헤결
15:56:51.586 [       t1] 거래 시작: BankAccountV3 
15:56:51.586 [       t2] 거래 시작: BankAccountV3 
15:56:51.600 [       t1] [검증 시작] 출금액: 800, 잔액: 1000 
15:56:51.600 [       t1] [검증 완료] 출금액: 800, 잔액: 1000 
15:56:52.010 [     main] t1 state : TIMED_WAITING 
15:56:52.011 [     main] t2 state : BLOCKED 
15:56:52.602 [       t1] [출금 완료] 출금액: 800, 변경 잔액: 200 
15:56:52.603 [       t1] 거래 종료 
15:56:52.603 [       t2] [검증 시작] 출금액: 800, 잔액: 200 
15:56:52.606 [       t2] [검증 실패] 출금액: 800, 잔액: 200 
15:56:52.618 [     main] 최종 잔액 : 200 

 * */
public class BankMain3 {
	
	public static void main(String args[]) throws InterruptedException {

		BankAccount account = new BankAccountV3(1000); //x001
		
		Thread t1 = new Thread(new WithdrawTask(account, 800),"t1"); //x002
		Thread t2 = new Thread(new WithdrawTask(account, 800),"t2"); //x003
		
		t1.start();
		t2.start();
		
		sleep(500);
		log("t1 state : "+t1.getState());
		log("t2 state : "+t2.getState());
		
		t1.join();
		t2.join();
		
		log("최종 잔액 : "+account.getBalance());
	}

}
