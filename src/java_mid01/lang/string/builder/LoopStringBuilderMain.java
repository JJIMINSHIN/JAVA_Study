package java_mid01.lang.string.builder;

/*
 * time = 7 ms
 * 
 * */
public class LoopStringBuilderMain {
	
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<100000; i++) {
			sb.append("Hello Java ");
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("sb = "+sb.toString());
		System.out.println("time = "+ (endTime-startTime) +" ms");
	}

}
