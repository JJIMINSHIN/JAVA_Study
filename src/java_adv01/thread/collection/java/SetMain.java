package java_adv01.thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * 실행 결과
copySet = [1, 2, 3]
skipSet = [1, 2, 3]ㄴ
 * */ 
public class SetMain {
	
	public static void main(String args[]) {
		Set<Integer> copySet = new CopyOnWriteArraySet<>();
		
		copySet.add(1);
		copySet.add(2);
		copySet.add(3);
		System.out.println("copySet = " + copySet);
		
		Set<Integer> skipSet = new ConcurrentSkipListSet<Integer>();
		
		skipSet.add(3);
		skipSet.add(2);
		skipSet.add(1);
		System.out.println("skipSet = " + skipSet);

		
	}
	
}
