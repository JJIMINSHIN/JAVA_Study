package java_adv01.thread.collection.java;

import java.util.*;

/*
 * 실행 결과
class java.util.Collections$SynchronizedRandomAccessList
list = [data1, data2, data3]

 * */
public class SynchronizedListMain {
	
	public static void main(String args[]) {
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		
		list.add("data1");
		list.add("data2");
		list.add("data3");
		
		System.out.println(list.getClass());
		System.out.println("list = "+list);
	}

}
