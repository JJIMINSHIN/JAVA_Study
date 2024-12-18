package java_bsc.static1;

public class DataCountMain3 {

	public static void main(String args[]) {
		Data3 data1 = new Data3("A");
		System.out.println("A cnt=" + Data3.cnt);
		
		Data3 data2 = new Data3("B");
		System.out.println("B cnt=" + Data3.cnt);
		
		Data3 data3 = new Data3("C");
		System.out.println("C cnt=" + Data3.cnt);
		
		Data3 data4 = new Data3("C");
		//인스턴스를 통한 접근
		System.out.println("data4.cnt=" + data4.cnt);
		
		//클래스를 통한 접근
		System.out.println("Data3.cnt="+Data3.cnt);
		
	}
}
