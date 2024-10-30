package java_mid01.lang.string.builder;

/*
 * time = 5479 ms
 * 5.4초
 * */
public class LoopStringMain {
	
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		
		String res ="";
		for(int i=0; i<100000; i++) {
			res += "Hello Java ";
			// => res =new StringBuilder().append(res).append("Hello Java ").toString();
		}
		
		long endTime = System.currentTimeMillis();

		System.out.println("res = "+res);
		System.out.println("time = "+ (endTime-startTime) +" ms");
	}

}
