package java_mid01.lang.nested.local;

/*
 * 실행 결과
value = 0
localVar = 1
paramVar = 2
outInstanceVar = 3
 * 
 * */
public class LocalOuterV1 {

	private int outInstanceVar = 3;
	
	public void process(int paramVar) {
		
		int localVar =1;
		
		class LocalPrinter{
			int value =0;
			
			public void printData() {
				System.out.println("value = "+value);
				System.out.println("localVar = "+localVar);
				System.out.println("paramVar = "+paramVar);
				System.out.println("outInstanceVar = "+outInstanceVar);
			}
		}//LocalPrinter
		
		LocalPrinter printer = new LocalPrinter();
		printer.printData();
		
	}
	
	public static void main(String args[]) {
		LocalOuterV1 localOuter = new LocalOuterV1();
		localOuter.process(2);
	}
}
