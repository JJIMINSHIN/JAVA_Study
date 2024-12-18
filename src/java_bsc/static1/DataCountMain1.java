package java_bsc.static1;

public class DataCountMain1 {

	public static void main(String args[]) {
		Data1 data1 = new Data1("A");
		System.out.println("A cnt=" + data1.cnt);
		
		Data1 data2 = new Data1("B");
		System.out.println("B cnt=" + data2.cnt);
		
		Data1 data3 = new Data1("C");
		System.out.println("C cnt=" + data3.cnt);
	}
}
