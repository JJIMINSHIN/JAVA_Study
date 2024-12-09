package java_bsc.ref;

/*
 * 실행 결과
 * Exception in thread "main" java.lang.NullPointerException: 
 * Cannot assign field "value" because "data" is nulls
 * */
public class NullMain2 {
	public static void main(String args[]) {
		Data data =null;
		data.value =10;
		System.out.println("data = "+data);
	}
}
