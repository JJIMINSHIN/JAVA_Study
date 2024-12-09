package java_bsc.ref;

/*
 * 실행 결과
1. data = null
2. data = java_bsc.ref.Data@16b4a017
3. data = null
 * */
public class NullMain1 {
	public static void main(String args[]) {
		Data data =null;
		System.out.println("1. data = "+data);
		data = new Data();
		System.out.println("2. data = "+data);
		data = null;
		System.out.println("3. data = "+data);
		
	}
}
