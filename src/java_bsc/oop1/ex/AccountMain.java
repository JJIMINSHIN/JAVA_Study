package java_bsc.oop1.ex;

public class AccountMain {
	public static void main(String args[]) {
		Account account = new Account();
		//10000 입금
		account.deposit(10000);
		
		//9000 출금
		account.withdraw(9000);
		
		//2000 출금
		account.withdraw(2000);
		System.out.println("잔고 = "+account.balance);

	}
	
}
