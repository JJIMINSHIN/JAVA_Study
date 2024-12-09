package java_bsc.ref;

/*
 * 실행 결과
 * bigData.count = 0
 * bigData.data = null
 * Exception in thread "main" java.lang.NullPointerException
 * */
public class NullMain3 {
	public static void main(String args[]) {
		BigData bigData = new BigData();
		System.out.println("bigData.count = "+bigData.count); // 0
		System.out.println("bigData.data = "+bigData.data); // null
		
		System.out.println("bigData.data.value = "+bigData.data.value); // null
		
	}
}
