package java_mid01.lang.nested.anonymous;

import java_mid01.lang.nested.local.Printer;

/*
 * 실행 결과
value = 0
localVar = 1
paramVar = 2
outInstanceVar = 3
printer = class java_mid01.lang.nested.anonymous.AnonympusOuter$1
 * */
public class AnonympusOuter {
	private int outInstanceVar = 3;
	
	public void process(int paramVar) {
		
		int localVar =1;
		
		Printer printer = new  Printer() {
			int value =0;
			
			@Override
			public void print() {
				System.out.println("value = "+value);
				System.out.println("localVar = "+localVar);
				System.out.println("paramVar = "+paramVar);
				System.out.println("outInstanceVar = "+outInstanceVar);
			}
		};//LocalPrinter
		printer.print();
		System.out.println("printer = "+printer.getClass());
	}
	
	public static void main(String args[]) {
		AnonympusOuter	main = new AnonympusOuter();
		main.process(2);
	}

}
