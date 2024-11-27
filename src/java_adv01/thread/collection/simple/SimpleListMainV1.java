package java_adv01.thread.collection.simple;

import java.util.ArrayList;
import java.util.List;

import java_adv01.thread.collection.simple.list.BasicList;
import java_adv01.thread.collection.simple.list.SimpleList;

public class SimpleListMainV1 {
	
	public static void main(String args[]) {
		SimpleList list = new BasicList();
		
		// 스레드1, 스레드2 동시에 실행 가정
		list.add("A");
		list.add("B");
		System.out.println(list);
		
	}

}
