package java_bsc.ref;

/*
 * 실행 결과
 * bigData.count = 0
 * bigData.data = java_bsc.ref.Data@2eafffde
 * bigData.data.value = 0
 * */
public class NullMain4 {
	public static void main(String args[]) {
		BigData bigData = new BigData();
		//NullPointerException 해결
		bigData.data = new Data();
		
		System.out.println("bigData.count = "+bigData.count); // 0
		System.out.println("bigData.data = "+bigData.data); // null
		System.out.println("bigData.data.value = "+bigData.data.value); // null
		
	}
}
