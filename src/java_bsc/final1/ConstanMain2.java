package java_bsc.final1;

public class ConstanMain2 {
	
	public static void main(String args[]) {
		System.out.println("프로그램 최대 참여자 수 = "+1000);
		int currentUserCnt = 999;
		process(currentUserCnt++);
		process(currentUserCnt++);
		process(currentUserCnt++);
		process(currentUserCnt++);
		
	}
	
	private static void process(int currentUserCnt) {
		System.out.println("참여자 수 : "+currentUserCnt);
		if(currentUserCnt> Constant.MAX_USERS) System.out.println("대기자로 등록합니다.");
		else System.out.println("게임에 참여합니다.");
	}

}
